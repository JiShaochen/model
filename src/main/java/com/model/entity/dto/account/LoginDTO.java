package com.model.entity.dto.account;

import com.model.common.utils.md5.MD5Utils;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Morning JS
 * @date 2021/4/15 17:47
 * @desc 登录dto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    private static final String salt = "Morning JS";

    private String userName;
    private String password;

    public String getPassword() {
        try {
            return MD5Utils.md5Bit16Upper(this.password + salt);
        } catch (Exception e) {
            // TODO 集成日志
            System.out.println("加密错误");
        } finally {
            return "";
        }
    }
}