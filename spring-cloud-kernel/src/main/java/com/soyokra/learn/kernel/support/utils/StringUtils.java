package com.soyokra.learn.kernel.support.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符串工具类
 */
public class StringUtils extends org.springframework.util.StringUtils {


    /**
     * 去除首位字符
     * @param str 字符串
     * @param element 字符
     * @return 移除后的字符串
     */
    public static String trim(String str, String element) {
        return trim(str, element, element, false);
    }

    /**
     * 去除首位字符
     * @param str 字符串
     * @param firstElement 首字符
     * @param lastElement 尾字符
     * @param loop 是否循环移除 
     * @return 移除后的字符串
     */
    public static String trim(String str, String firstElement, String lastElement, boolean loop) {
        if (! hasLength(str)) {
            return str;
        }
        boolean beginIndexFlag;
        boolean endIndexFlag;
        do{
            int beginIndex = 0;
            if (hasLength(firstElement)) {
                beginIndex = str.indexOf(firstElement) == 0 ? 1 : 0;
            }

            int endIndex =  str.length();
            if (hasLength(lastElement)) {
                endIndex = str.lastIndexOf(lastElement) + 1 == str.length() ? str.lastIndexOf(lastElement) : str.length();
            }
            str = str.substring(beginIndex, endIndex);
            if (loop) {
                beginIndexFlag = (str.indexOf(firstElement) == 0);
                endIndexFlag = (str.lastIndexOf(lastElement) + 1 == str.length());
            } else {
                beginIndexFlag = false;
                endIndexFlag = false;
            }
        } while (beginIndexFlag || endIndexFlag);
        return str;
    }

    /**
     * 字符串根据分隔符转换为字符串数组
     * @param str 字符串
     * @param delimiter 分隔符
     * @return 字符串数组
     */
    public static List<String> explode(String str, String delimiter) {
        if (! hasLength(str)) {
            return new ArrayList<>();
        }
        return Arrays.asList(str.split(delimiter));
    }

    /**
     * 字符串数组根据分隔符转换为字符串
     * @param list 字符串数组
     * @param delimiter 分隔符
     * @return 字符串
     */
    public static String implode(List<String> list, String delimiter) {
        if (list == null) {
            return "";
        }

        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuffer.append(delimiter);
            }
            stringBuffer.append(list.get(i));
        }
        return stringBuffer.toString();
    }

    /**
     * 转换为string，可为null
     * @param value value
     * @param <T> valueType
     * @return string value
     */
    public static <T> String toStringNullable(T value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }
}
