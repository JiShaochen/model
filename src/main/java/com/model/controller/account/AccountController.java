package com.model.controller.account;

import com.model.common.utils.apiresult.AbstractApiResult;
import com.model.entity.dto.account.LoginDTO;
import com.model.service.account.AccountService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Morning JS
 * @date 2021/4/15 17:45
 * @desc 账号相关
 */
@Api(value = "/account", tags = "账号相关")
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Resource
    AccountService accountService;

    public AbstractApiResult login(@RequestBody LoginDTO loginDTO, HttpServletResponse response) {
        accountService.login(loginDTO, response);
        return AbstractApiResult.success();
    }


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        int i = atomicInteger.get();
        int i1 = atomicInteger.get();
        System.out.println(i + "   " + i1);

    }

}