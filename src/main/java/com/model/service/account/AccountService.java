package com.model.service.account;

import com.model.entity.dto.account.LoginDTO;
import com.model.entity.dto.account.RegisterDTO;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author Morning JS
 * @date 2021/4/15 17:46
 * @desc 账户服务
 */
@Validated
public interface AccountService {
    void login(LoginDTO loginDTO);

    /**
     * 注册账号
     * @param registerDTO
     */
    void register(@Valid RegisterDTO registerDTO);
}
