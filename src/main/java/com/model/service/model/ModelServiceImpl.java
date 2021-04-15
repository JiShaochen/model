package com.model.service.model;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.common.utils.page.PageParam;
import com.model.common.utils.page.PageResult;
import com.model.common.utils.page.PageResultFactory;
import com.model.entity.model.Account;
import com.model.entity.vo.CourseVO;
import com.model.mapper.AccountMapper;
import com.model.mapper.model.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Collections;
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
    public String getTest() {
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

        account.setEquipment("CTX123456");
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
}