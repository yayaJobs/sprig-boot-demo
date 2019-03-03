package com.yaya.spring.boot.demo.utils;

import java.util.Arrays;
import java.util.Objects;

public class NoName {

    /**
     * 代码是对两个字符串进行比较，比较规则为字符串组成字符的种类和数目是否一致。
     * 若构成两个字符串的字符种类及各个种类出现的数目都一致，则返回true，否则返回false。
     *
     * @param a
     * @param b
     * @return
     */
    public static Boolean noName(String a, String b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            System.err.println("传入参数异常，存在null");
            return Boolean.FALSE;
        }
        if (a.length() != b.length()) {
            return Boolean.FALSE;
        }
        String sortA = sortString(a);
        String sortB = sortString(b);
        if (sortA == null || !sortA.equals(sortB)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;

    }

    /**
     * 进行字符串内容默认排序
     *
     * @param a
     * @return
     */
    public static String sortString(String a) {
        if (Objects.isNull(a)) {
            System.err.println("传入参数为null");
            return null;
        }
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
