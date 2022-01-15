package com.model.service.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.model.common.utils.exception.ExceptionManager;
import com.model.common.utils.jwt.JWTUtils;
import com.model.entity.dto.account.LoginDTO;
import com.model.entity.dto.account.RegisterDTO;
import com.model.entity.model.Account;
import com.model.mapper.AccountMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author Morning JS
 * @date 2021/4/15 17:46
 * @desc 账户服务
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountMapper accountMapper;

    @Resource
    ExceptionManager exceptionManager;

    
    /**
     * @Author: Morning JS
     * @Description: 登录颁发jwt密钥
     * @Date: 2021/4/15
    */ 
    @Override
    public void login(LoginDTO loginDTO) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Account::getPassword, loginDTO.getPassword()).eq(Account::getUsername, loginDTO.getUsername());
        Account account = accountMapper.selectOne(queryWrapper);
        if (Objects.isNull(account)) {
            throw exceptionManager.createByCode("ACCOUNT_0001");
        }
        String token = JWTUtils.geneJsonWebToken(account);

    }

    @Override
    public void register(RegisterDTO registerDTO) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Account::getUsername, registerDTO.getUsername());
        Integer count = accountMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw exceptionManager.createByCode("ACCOUNT_0006");
        }
        Account account = Account.newInstance(registerDTO);
        accountMapper.insert(account);
    }
}
