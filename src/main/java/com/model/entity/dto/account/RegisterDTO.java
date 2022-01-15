package com.model.entity.dto.account;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author JiShaochen
 * @date 2022/1/15 17:35
 * @desc 注册对象
 */
@Data
@ApiModel("注册账户请求体")
public class RegisterDTO {

    @ApiModelProperty("用户名")
    @NotNull(message = "ACCOUNT_0002")
    private String username;
    @ApiModelProperty("ACCOUNT_0003")
    private String realName;
    @ApiModelProperty("ACCOUNT_0005")
    private Integer position;
    @ApiModelProperty("ACCOUNT_0004")
    private String email;

}