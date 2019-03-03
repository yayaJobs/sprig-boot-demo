package com.yaya.spring.boot.demo.utils;

import java.util.Objects;

public class NoNameV0 {

    public static Boolean noName(String a, String b) {
        System.out.println("noName:a=" + a + ";b=" + b);
        if (Objects.isNull(a) || Objects.isNull(b)) {
            System.err.println("noName 无效请求参数");
            return Boolean.FALSE;
        }
        if (a.length() != b.length()) {
            return Boolean.FALSE;
        }
        for (int x = 0; x < b.length(); x++) {
            if (a.charAt(0) == b.charAt(x)) {
                return noName(utilityFunction(a, 0), utilityFunction(b, x));
            }
        }
        if (b.length() == 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static String utilityFunction(String s, int j) {
        if (Objects.isNull(s)) {
            System.err.println("utilityFunction 无效请求参数");
            return null;
        }
        char[] ret = new char[s.length() - 1];
        int d = 0;
        for (int k = 0; k < s.length(); k++) {
            if (k == j) {
                d = 1;
            } else {
                ret[k - d] = s.charAt(k);
            }
        }
        return new String(ret);
    }

    public static void main(String args[]) {
//        System.out.println(noName(null, "aaaaaa"));
//        System.out.println(noName("aaaaaa", null));
//        String a = "哈逼 test 王振亚";
//        System.out.println("utilityFunction: a =" + a);
//        for (int i = 0; i < a.length(); i++) {
//            System.out.print("utilityFunction: i=" + i);
//            System.out.println(" ;result=" + utilityFunction(a, i));
//        }

//        String a = "aabc";
//        String b = "acba";
//        System.out.println(noName(a, b));

        String a = "ha 西欧奥更换ha woy 我要测试一下";
        int[] ints = a.chars().sorted().toArray();
        System.out.println("length="+ints.length);
        for (int i : ints) {
            System.out.println(i);
        }

        ints = a.codePoints().sorted().toArray();
        System.out.println("length="+ints.length);
        for (int i : ints) {
            System.out.println(i);
        }
    }


}
