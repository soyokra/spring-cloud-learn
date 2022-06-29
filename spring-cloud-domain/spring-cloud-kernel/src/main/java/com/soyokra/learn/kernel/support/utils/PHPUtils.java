package com.soyokra.learn.kernel.support.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * php函数工具类
 */
public class PHPUtils {

    /**
     * http_build_query
     */
    public static String http_build_query(Map<String, Object> params){
        String str = http_query_build_recursive(params,"",true);
        if (str.lastIndexOf("&") == (str.length() - 1)) {
            str = str.substring(0, (str.length() - 2));
        }
        return str;
    }

    /**
     * urlencode
     */
    public static String urlencode(String query) {
        try {
            query = java.net.URLEncoder.encode(query,"utf-8").replace("*", "%2A");
        } catch (UnsupportedEncodingException ignored) {

        }
       return query;
    }

    /**
     * ksort
     */
    public static Map<String, Object> ksort(Map<String, Object> map) {
        Map<String, Object> sortMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(t->sortMap.put(t.getKey(), t.getValue()));
        return sortMap;
    }

    /**
     * json_encode
     */
    public static String json_encode(Object map) {
        try {
            String s = new ObjectMapper().writeValueAsString(map);
            s = s.replace("/", "\\/");
            s = chineseCharacterToUnicode(s);
            return s;
        } catch (Exception ignored) {
            return null;
        }
    }

    /**
     * array_filter
     */
    public static Map<String, Object> array_filter(Map<String, Object> map) {
        map.entrySet().removeIf(entry -> empty(entry.getValue()));
        return map;
    }

    /**
     * empty
     */
    public static Boolean empty(Object o) {
        if (o == null) {
            return Boolean.TRUE;
        }
        if (o instanceof String) {
            return o.equals("") || o.equals("0");
        } else if(o instanceof Collection) {
            return ((Collection) o).isEmpty();
        } else if (o instanceof Number) {
            return ((Number) o).doubleValue() == 0;
        }
        return Boolean.FALSE;
    }

    private static String http_query_build_recursive(Object object, String parentStr, boolean first) {
        StringBuilder r= new StringBuilder();
        if(object instanceof Map){
            List<Map.Entry<String,Object>> list = new ArrayList<>(((Map<String, Object>) object).entrySet());
            for(Map.Entry<String,Object> mapping:list){
                String key = mapping.getKey();
                Object value = mapping.getValue();

                if(first){
                    r.append(http_query_build_recursive(value, key, false));
                }else{
                    r.append(http_query_build_recursive(value, parentStr + urlencode("[") + key + urlencode("]"), false));
                }

            }
        }else if(object instanceof List){
            for (int i = 0; i <((List)object).size() ; i++) {
                r.append(http_query_build_recursive(((List) object).get(i), parentStr + urlencode("[") + i + urlencode("]"), false));
            }
        }else if(object instanceof String){
            r.append(parentStr).append("=").append(urlencode(object.toString())).append("&");
        }else if(object instanceof Number){
            r.append(parentStr).append("=").append(urlencode(((Number) object).toString())).append("&");
        }
        return r.toString();
    }

    private static String chineseCharacterToUnicode(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int chr1 = (char) str.charAt(i);
            if (chr1 >= 19968 && chr1 <= 171941) {//汉字范围 \u4e00-\u9fa5 (中文)
                result += "\\u" + Integer.toHexString(chr1);
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }
}