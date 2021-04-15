package com.model.service.account;

import com.model.entity.dto.account.LoginDTO;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Morning JS
 * @date 2021/4/15 17:46
 * @desc 账户服务
 */
public interface AccountService {
    void login(LoginDTO loginDTO, HttpServletResponse response);
}
