package com.yaya.spring.boot.demo.utils;

public class NoNameTest {
    public static void main(String args[]) {
        //异常数据测试
        NoNameTest test = new NoNameTest();
        test.noNameTest("", null);
        test.noNameTest(null, "");
        test.noNameTest("", "");

    }

    public void noNameTest(String a, String b) {
        System.out.println("test for noName");
        System.out.println("input a = " + a);
        System.out.println("input b = " + b);
        System.out.println("noName result = " + NoName.noName(a, b));
    }

}
