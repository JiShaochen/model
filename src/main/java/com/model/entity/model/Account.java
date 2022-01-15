package com.model.entity.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.model.common.utils.mapper.MapperUtils;
import com.model.common.utils.md5.MD5Utils;
import com.model.common.utils.random.RandomUtils;
import com.model.entity.dto.account.RegisterDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author Morning JS
 * @date 2021/4/15 15:47
 * @desc 账户表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("account")
public class Account implements Serializable {

    private static final long serialVersionUID = -7148327092097653501L;
    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 工号
     */
    private String jobNumber;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 职位编码
     */
    private Integer position;
    /**
     * 用户状态
     */
    private Integer status;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;



    public static Account newInstance(RegisterDTO registerDTO) {
        if (Objects.isNull(registerDTO)) {
            return new Account();
        }
        Account account = MapperUtils.mapperBean(registerDTO, Account.class);
        try {
            account.setPassword(MD5Utils.md5Bit32Upper("123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        account.setStatus(0);
        account.setJobNumber(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + RandomUtils.getRandomNum(4));
        account.setCreateTime(LocalDateTime.now());
        account.setUpdateTime(account.getCreateTime());
        return account;
    }
}