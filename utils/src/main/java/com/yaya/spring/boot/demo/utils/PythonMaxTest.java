package com.yaya.spring.boot.demo.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PythonMaxTest {

    public static void main(String[] args) {
        //数组测试
        System.out.println(PythonMax.max(new String[]{"test", "good", "aaaa"}));
        System.out.println(PythonMax.max(new Integer[]{7, 6, 4, 2, 3, 1, 12, 18}));
        System.out.println(PythonMax.max(new Character[]{'a', ' ', 'e', ' ', 'f', 'a', 'E'}));

        //多参数
        System.out.println(PythonMax.max("a", "b", "c", "d", "e"));

        Logger logger = Logger.getLogger("com.yaya.spring.boot.demo.utils.PythonMax");
        logger.setLevel(Level.ALL);
        // logger.info("" + max(1));
        logger.info("" + PythonMax.max(1, 2));
        logger.info("" + PythonMax.max(1, 2, 3));
        logger.info("" + PythonMax.max("1234"));
        //logger.info(max(1, 2, 3, '3'));
        logger.info(PythonMax.max("ab", "ac", "ad"));
        logger.info("" + PythonMax.max(-1, 0));
        Function<Integer, Integer> abs = s -> Math.abs(s);
        logger.info("" + PythonMax.max(abs, -1, 0, -8, 7));

        List<Object> test = new ArrayList<>();
        test.add(0);
        test.add(2);
        test.add(8);
        test.add(7);
        logger.info("" + PythonMax.max((Collection) test));
        test.clear();
        test.add(0);
        logger.info("" + PythonMax.max((Collection) test));
        test.clear();
    }
}
