package com.yaya.spring.boot.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NoNameTest {
    private static Logger logger;

    static {
        logger = Logger.getLogger("com.yaya.spring.boot.demo.utils.NoNameTest");
        logger.setLevel(Level.ALL);
    }

    public static void main(String args[]) {
        NoNameTest test = new NoNameTest();
        test.testForAssert();
        test.testForInput();

    }

    public void testForInput() {
        logger.info("testForInput 请输入noName 第一个参数:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String a = br.readLine();
            logger.info("testForInput 请输入noName 第二个参数:");
            String b = br.readLine();
            Boolean result = noNameTest(a, b);
            logger.info("testForInput 结果 result=" + result);
        } catch (IOException e) {
            logger.log(Level.WARNING, "IOException e =%s", e.getLocalizedMessage());
        }

    }

    /**
     * 预备数据测试-IDE需开启断言
     */
    public void testForAssert() {
        assert noNameTest("", null) == Boolean.FALSE : "出现异常";
        assert noNameTest(null, "") == Boolean.FALSE : "出现异常";
        assert noNameTest("", "") == Boolean.TRUE : "出现异常";
        assert noNameTest("我是想测试 abchaha", "abchaha 我是想测试 ") == Boolean.FALSE : "出现异常";
        assert noNameTest("我是想测试 abchaha", "abchaha 我是想测试") == Boolean.TRUE : "出现异常";
        assert noNameTest("test for noMane", "manetest for no") == Boolean.FALSE : "出现异常";
        assert noNameTest("test for noMane", "test for noMan") == Boolean.FALSE : "出现异常";
        assert noNameTest("test for noMane", "test for ceshi") == Boolean.FALSE : "出现异常";
        assert noNameTest("ababbb", "abaabb") == Boolean.FALSE : "出现异常";
    }

    public Boolean noNameTest(String a, String b) {
        logger.info(String.format("test for noName:\ninput a = %s\ninput b = %s", a, b));
        Boolean result = NoName.noName(a, b);
        logger.info("noName result = " + result);
        return result;
    }

}
