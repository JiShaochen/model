package com.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.model.entity.model.Account;
import org.mapstruct.Mapper;

/**
 * @author Morning JS
 * @date 2021/4/15 15:55
 * @desc 账户表mapper
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
