package com.model.common.utils.response;

import com.model.common.utils.json.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Leo
 * @className: CommonResponseVO
 * @desc 返回参数
 * @date 2020/6/16 11:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponseVO<T> {
    // 状态码
    private String code;
    // 返回信息
    private String  msg;
    // 返回数据
    private T data;

    public Object getData(Class clazz) {
        return JsonUtils.jsonToBean(JsonUtils.beanToJson(this.data), clazz);
    }

    public String getDataListJson() {
        return JsonUtils.beanToJson(this.data);
    }

}
