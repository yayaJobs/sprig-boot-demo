package com.yaya.spring.boot.demo.utils;

public class PythonMaxTest {

    public static void main(String[] args) {
        //数组测试
        System.out.println(PythonMax.max(new String[]{"test", "good", "aaaa"}));
        System.out.println(PythonMax.max(new Integer[]{7, 6, 4, 2, 3, 1, 12, 18}));
        System.out.println(PythonMax.max(new Character[]{'a', ' ', 'e', ' ', 'f', 'a', 'E'}));

        //多参数
        System.out.println(PythonMax.max("a", "b", "c", "d", "e"));
    }
}
