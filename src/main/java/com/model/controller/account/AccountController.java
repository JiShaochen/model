package com.model.controller.account;

import com.model.common.utils.apiresult.AbstractApiResult;
import com.model.entity.dto.account.LoginDTO;
import com.model.entity.dto.account.RegisterDTO;
import com.model.service.account.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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

    public AbstractApiResult login(@RequestBody LoginDTO loginDTO) {
        accountService.login(loginDTO);
        return AbstractApiResult.success();
    }

    @ApiOperation(value = "注册账号")
    @PostMapping("/register")
    public AbstractApiResult register(@RequestBody RegisterDTO registerDTO) {
        accountService.register(registerDTO);
        return AbstractApiResult.success();
    }

}