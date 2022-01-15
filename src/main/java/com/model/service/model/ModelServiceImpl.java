package com.model.service.model;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.common.utils.date.LocalDateTimeUtils;
import com.model.common.utils.page.PageParam;
import com.model.common.utils.page.PageResult;
import com.model.common.utils.page.PageResultFactory;
import com.model.entity.model.Account;
import com.model.entity.model.Mail;
import com.model.entity.vo.CourseVO;
import com.model.mapper.AccountMapper;
import com.model.mapper.model.ModelMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Morning JS
 * @date 2020/12/7 16:59
 * @desc 实现类
 */
@Service
public class ModelServiceImpl implements ModelService {

    @Resource
    ModelMapper modelMapper;

    @Resource
    PageResultFactory pageResultFactory;

    @Resource
    AccountMapper accountMapper;

    @Override
    @Async
    public String getTest() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return modelMapper.getTest();
    }

    @Override
    public CourseVO getOne() {
        return modelMapper.getOne();
    }

    @Override
    public void postTest(CourseVO courseVO) {
        LocalDateTime now = LocalDateTime.now();
//        Account build = Account.builder().townId(1).accountType("超级管理员").createTime(now).modifyTime(now).equipment("").password("123456").phone("13505721612").status("VALID").build();
//        accountMapper.insert(build);
//        System.out.println(build.getId());

        Account account = accountMapper.selectById(94502);
        System.out.println(account);

        accountMapper.updateById(account);

        QueryWrapper<Account> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(Account::getStatus, "VALID");

        Account account1 = accountMapper.selectOne(queryWrapper);
        System.out.println(account1);

//        modelMapper.postTest(courseVO);
    }

    @Override
    @Transactional(readOnly = true)
    public PageResult postList(PageParam pageParam) {
        PageHelper.startPage(pageParam.getP(), pageParam.getC());
        List<CourseVO> list = modelMapper.getList();
        if (CollectionUtils.isEmpty(list)) {
            return pageResultFactory.createPageResult(pageParam.getP(), 0, Collections.EMPTY_LIST);
        }
        int total = (int) new PageInfo(list).getTotal();
        return pageResultFactory.createPageResult(pageParam.getP(), total, list);
    }

    @Override
    public void sendMail() {
        List<Mail> mail = modelMapper.listMails();
        mail.stream().forEach(item -> {
            if (StringUtils.isEmpty(item.getMessage())
                    || StringUtils.isEmpty(item.getTitle())
                    || StringUtils.isEmpty(item.getMail())
                    || StringUtils.isEmpty(item.getName())
                    || item.getSendStatus() == 1) {
                return;
            }
            send163Mail(item);
        });
    }

    @Resource
    JavaMailSender javaMailSender;

    public void send163Mail(Mail mail) {
       try {
           // 构建一个邮件对象
           SimpleMailMessage message = new SimpleMailMessage();
           // 设置邮件主题
           String title = mail.getTitle();
           LocalDateTime now = LocalDateTime.now();
           LocalDateTime parse = LocalDateTime.parse("2022-02-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
           long twoTime = LocalDateTimeUtils.betweenTwoTime(now, parse, ChronoUnit.DAYS);
           if (now.isAfter(parse)) {
               return;
           }
           if (title.contains("xx")) {
               title = title.replace("xx", mail.getName());
           }
           message.setSubject(title + "还有" + twoTime + "天就过年了！");
           String auto = doGet();
           // 设置邮件发送者，这个跟application.yml中设置的要一致
           message.setFrom("17611413208@163.com");
           // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
           // message.setTo("10*****16@qq.com","12****32*qq.com");
           message.setTo(mail.getMail());
           // 设置邮件发送日期
           message.setSentDate(new Date());
           // 设置邮件的正文
           String message1 = mail.getMessage();
           if (message1.contains("xx")) {
               message1 = message1.replace("xx", mail.getName()) + "\r\n \r\n" + auto;
           }
           message.setText(message1);
           // 发送邮件
           javaMailSender.send(message);

           Thread.sleep(800);
       } catch (Exception e) {
           System.out.println("报错了: " + mail.getName() + e.getMessage());
       }
    }

    public static String doGet() {
        String url = "https://chp.shadiao.app/api.php";
        try {
            HttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());

                return strResult;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}