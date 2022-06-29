package com.soyokra.learn.kernel.support.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json工具类
 */
public class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper() {{
        // 序列化忽略非空
        this.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        // 忽略额外 json 结构
        this.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }};


    public static ObjectMapper mapper() {
        return MAPPER;
    }

    public static String objectToString(Object value) {
        return objectToString(mapper(), value);
    }

    public static String objectToString(ObjectMapper mapper, Object value) {
        try {
            return mapper.writeValueAsString(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T stringToObject(String content, Class<T> valueType) {
        return stringToObject(mapper(), content, valueType);
    }

    public static <T> T stringToObject(ObjectMapper mapper, String content, Class<T> valueType) {
        try {
            return mapper.readValue(content, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T stringToObject(String content, TypeReference<T> valueType) {
        return stringToObject(mapper(), content, valueType);
    }

    public static <T> T stringToObject(ObjectMapper mapper, String content, TypeReference<T> valueType) {
        try {
            return mapper.readValue(content, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
