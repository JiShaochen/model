package com.model.common.utils.apiresult;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author    Morning JS
 * @date    2017/7/21 上午11:28
 * @desc    正确返回体
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SuccessApiResult extends AbstractApiResult {

    private Object data;

    SuccessApiResult(Object data) {
        this.code = "0";
        this.data = data;
    }

}
