package com.model.common.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;


/**
 * @Author: Morning JS
 * @Description: 解决BigDecimalSerialize序列化json丢失精度问题
 * @Date: 2021/4/23
*/
public class BigDecimalSerialize extends JsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        if (!StringUtils.isEmpty(value)) {
            gen.writeString(value.setScale(2, BigDecimal.ROUND_HALF_DOWN) + "");
        } else {
            gen.writeString(value + "");
        }
    }
}
