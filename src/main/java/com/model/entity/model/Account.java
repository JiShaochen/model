package com.model.entity.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

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
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String status;
    private String accountType;
    private String equipment;
    private String phone;
    private String password;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private Integer townId;
}