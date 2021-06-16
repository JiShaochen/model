package com.model.service.transaction;

import com.model.common.utils.exception.ExceptionManager;
import com.model.common.utils.http.HttpClient;
import com.model.common.utils.json.JsonUtils;
import com.model.common.utils.md5.MD5Utils;
import com.model.common.utils.uuid.UUIDUtils;
import com.model.entity.dto.transaction.TransactionDTO;
import com.model.entity.vo.TransactionInfoVO;
import com.model.entity.vo.TransactionVO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.File;
import java.net.URLEncoder;

/**
 * @author Morning JS
 * @date 2021/6/4 15:58
 * @desc
 */
@Service
public class TransactionServiceImpl implements TransactionService{

    @Resource
    ExceptionManager exceptionManager;

    private static final String url = "http://fanyi-api.baidu.com/api/trans/vip/translate";

    private static final String appId = "20210119000675750";

    private static final String sercet = "NKcyN99bHEg9wvPPZUH9";

    @Override
    public void transaction(TransactionDTO transactionDTO) throws Exception {
        File file = new File(transactionDTO.getPath());
        if (!file.exists()) {
            throw exceptionManager.createByMessage("此文件路径不存在，请检查");
        }
        if(!file.isDirectory()) {
            throw exceptionManager.createByMessage("此文件路径不是文件夹");
        }
        this.transactionFile(file, transactionDTO.getFlag());

    }

    private void transactionFile(File file, Boolean flag) throws Exception {
        File[] files = file.listFiles();
        if (files.length == 0) {
            return;
        }
        for (File item: files) {
            boolean directory = item.isDirectory();
            String name = item.getName();
            name = name.replace("_", " ");
            String fn = name;
            String suffix = "";
            if (!directory) {
                fn = name.substring(0, name.lastIndexOf("."));
                suffix = name.substring(name.lastIndexOf(".") + 1);
            }

            String salt = UUIDUtils.getUUID().substring(8);

            String demo = appId + fn + salt + sercet;

            System.out.println(demo);
            String sign = MD5Utils.md5Bit32Lower(demo);

            StringBuilder stringBuilder = new StringBuilder(url);
            stringBuilder.append("?q=");
            stringBuilder.append(URLEncoder.encode(fn, "utf-8"));
            stringBuilder.append("&from=auto&to=zh&appid=20210119000675750&salt=").append(salt);
            stringBuilder.append("&sign=").append(sign);
            System.out.println(stringBuilder.toString());
            String s = HttpClient.doGet(stringBuilder.toString());
            System.out.println(s);
            TransactionVO transactionVO = JsonUtils.jsonToBean(s, TransactionVO.class);
            if (CollectionUtils.isEmpty(transactionVO.getTrans_result())) {
                continue;
            }
            TransactionInfoVO result = transactionVO.getTrans_result().get(0);
            String dst = result.getDst();

//            String newFileName = fn + "-" + dst + "." + suffix;
            String newFileName = "【" + dst + "】" + fn;
            if (!directory) {
                newFileName = newFileName + "." + suffix;
            }

            File newFile = new File(file.getPath() + "//" + newFileName);
            item.renameTo(newFile);

            if (directory && flag) {
                transactionFile(newFile, flag);
            }

        }
    }
}