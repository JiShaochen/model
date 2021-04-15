package com.model.common.utils.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Morning JS
 * @date 2017/7/26 下午12:07
 * @desc Json工具.
 */
public final class JsonUtils {

    private JsonUtils() { }

    /**
     * json串转换为对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToBean(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * 对象转换为json
     * @param object
     * @return
     */
    public static String beanToJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 对象转换为json,可以带上date的格式化
     * @param object
     * @return
     */
    public static String beanToJson(Object object, String dateFormat) {
        if (Objects.isNull(dateFormat) || "".equals(dateFormat)) {
            return JSON.toJSONString(object);
        }
        return JSON.toJSONStringWithDateFormat(object, dateFormat);

    }

    /**
     * json返回List
     * @param arrayJson
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String arrayJson, Class<T> clazz, String dateFormat) {
        String temp = JSONObject.DEFFAULT_DATE_FORMAT;
        if (!"".equals(dateFormat) && dateFormat != null) {
            JSONObject.DEFFAULT_DATE_FORMAT = dateFormat;
        }
        List<T> list = JSON.parseArray(arrayJson, clazz);
        JSONObject.DEFFAULT_DATE_FORMAT = temp;
        return list;
    }

    public static <T> List<T> jsonToList(String arrayJson, Class<T> clazz) {
        return jsonToList(arrayJson, clazz, null);
    }

    /**
     * 反序列化Map
     * @param mapJson
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map jsonMap(String mapJson) {
        return JSON.parseObject(mapJson, new TypeReference<Map<K, V>>() { });
    }

    /**
     * @author: jespon
     * @methodName: toJson
     * @description: 对象转换为json字符串
     * @param: Object object 需转换的对象; String... dateTimeFormat 指定的日期格式
     * @return: String 转换结果
     * @Throws: null
     */
    public static String toJson(Object object, String... dateTimeFormat){
        return dateTimeFormat.length > 0 ? JSON.toJSONStringWithDateFormat(object, dateTimeFormat[0]) : JSON.toJSONString(object);
    }

    /**
     * @author: jespon
     * @methodName: toBean
     * @description: json字符串转换为对象
     * @param: String json 待转换json串; Class<T> clazz 结果类的泛型
     * @return: String 转换结果
     * @Throws: null
     */
    public static <T> T toBean(String json, Class<T> clazz){
        return JSON.parseObject(json, clazz);
    }

}
