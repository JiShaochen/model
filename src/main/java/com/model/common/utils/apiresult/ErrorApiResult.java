package com.model.common.utils.apiresult;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Morning JS
 * @date 2017/7/23 下午7:59
 * @desc  错误返回.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ErrorApiResult extends AbstractApiResult {

    private String msg;

    ErrorApiResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
