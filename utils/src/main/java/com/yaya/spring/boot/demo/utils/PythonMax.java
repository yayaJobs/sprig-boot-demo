package com.yaya.spring.boot.demo.utils;

import java.util.*;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PythonMax {

    /**
     * 返回可迭代比较对象集合最大值
     *
     * @param collection 集合
     * @param <T>        实现Comparable对象
     * @return 最大值对象
     */
    public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> collection) {
        if (Objects.isNull(collection) || collection.isEmpty()) {
            throw new NullPointerException("max collection is empty");
        }
        return Collections.max(collection);
    }

    /**
     * 通过函数key处理集合对象获取可比较值，依据处理结果获取最大对象
     *
     * @param collection 集合
     * @param key        集合对象比较值处理函数
     * @param <T>        集合对象
     * @param <R>        可比较的函数处理结果对象
     * @return 最大值对象
     */
    public static <T, R extends Object & Comparable<? super R>> T max(Collection<T> collection, Function<? super T, ? extends R> key) {
        if (Objects.isNull(collection) || collection.isEmpty()) {
            throw new NullPointerException("max collection is empty");
        }
        return max(collection, key, null);
    }

    /**
     * 通过函数key处理集合对象获取可比较值，依据处理结果获取最大对象。若defaultValue不为空，在无法获取最大值情况下返回defaultValue
     *
     * @param collection   集合
     * @param key          集合对象比较值处理函数
     * @param defaultValue 默认最大值
     * @param <T>          集合对象
     * @param <R>          可比较的函数处理结果对象
     * @return 最大值对象
     */
    public static <T, R extends Object & Comparable<? super R>> T max(Collection<T> collection, Function<? super T, ? extends R> key, T defaultValue) {
        if (Objects.isNull(collection) || collection.isEmpty()) {
            if (Objects.isNull(defaultValue)) {
                throw new NullPointerException("max collection is empty and defaultValue is null");
            }
            return defaultValue;
        }
        Iterator<? extends T> i = collection.iterator();
        T candidate = i.next();
        while (i.hasNext()) {
            T next = i.next();
            if (key.apply(next).compareTo(key.apply(candidate)) > 0)
                candidate = next;
        }
        return candidate;
    }

    /**
     * 通过函数key处理序列对象获取可比较值，依据处理结果获取最大对象。
     *
     * @param key   序列对象比较值处理函数
     * @param array 序列
     * @param <T>   序列对象
     * @param <R>   可比较的函数处理结果对象
     * @return
     */
    public static <T, R extends Object & Comparable<? super R>> T max(Function<? super T, ? extends R> key, T... array) {
        if (Objects.isNull(array)) {
            throw new NullPointerException("max array is empty");
        }
        if (array.length == 1) {
            throw new RuntimeException("max array length should more than one");
        }
        return max(Arrays.asList(array), key);
    }

    /**
     * 获取可迭代比较对象序列中最大值
     *
     * @param array 对象序列
     * @param <T>   可比较对象
     * @return 序列最大值
     */
    public static <T extends Object & Comparable<? super T>> T max(T... array) {
        if (Objects.isNull(array)) {
            throw new NullPointerException("max array is empty");
        }
        if (array.length == 1) {
            throw new RuntimeException("max array length should more than one");
        }

        return max(Arrays.asList(array));
    }

    public static char max(String string) {
        return (char) string.chars().max().getAsInt();
    }

    public static void main(String args[]) {
        Logger logger = Logger.getLogger("com.yaya.spring.boot.demo.utils.PythonMax");
        logger.setLevel(Level.ALL);
        // logger.info("" + max(1));
        logger.info("" + max(1, 2));
        logger.info("" + max(1, 2, 3));
        logger.info("" + max("1234"));
        //logger.info(max(1, 2, 3, '3'));
        logger.info(max("ab", "ac", "ad"));
        logger.info("" + max(-1, 0));
        Function<Integer, Integer> abs = s -> Math.abs(s);
        logger.info("" + max(abs, -1, 0, -8, 7));

        List<Object> test = new ArrayList<>();
        test.add(0);
        test.add(2);
        test.add(8);
        test.add(7);
        logger.info("" + max((Collection) test));
        test.clear();
        test.add(0);
        logger.info("" + max((Collection) test));
        test.clear();
    }
}
