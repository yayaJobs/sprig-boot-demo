package com.yaya.spring.boot.demo.utils;

import java.util.*;

public class PythonMax {


    /**
     * 获取可比较容器对象的最大值
     *
     * @param collection
     * @param <T>
     * @return
     */
    public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> collection) {
        Iterator<? extends T> i = collection.iterator();
        T candidate = i.next();
        while (i.hasNext()) {
            T next = i.next();
            if (next.compareTo(candidate) > 0)
                candidate = next;
        }
        return candidate;
    }


    /**
     * 获取对象数组最大值
     *
     * @param array
     * @return
     */
    public static Object max(Object... array) {
        if (Objects.isNull(array)) {
            System.err.println("max 参数异常");
            return null;
        }
        if (array.length == 1) {
            return array[0];
        }
        if (array.length > 2) {

        }
        return array[0];
    }
}
