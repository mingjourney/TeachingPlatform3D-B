package com.healthy.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author Gugu
 * @create 2022-07-20 20:01
 * @purpose json处理工具类
 */
public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();
    static {
        // 对于空的对象转json的时候不抛出错误
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 允许属性名称没有引号
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 允许单引号
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 设置输入时忽略在json字符串中存在但在java对象实际没有的属性
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 设置输出时包含属性的风格
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
    }

    /*
    * 对象转json
    * */

    public static String toJson(Object data){
        if(data == null){
            return null;
        }

        String json = null;
        try {
            json = mapper.writeValueAsString(data);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return json;
    }

    public static <T> T toObject(String json ,Class<T> clazz){
        T object = null;
        try {
            object = mapper.readValue(json, clazz);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  object;
    }
}
