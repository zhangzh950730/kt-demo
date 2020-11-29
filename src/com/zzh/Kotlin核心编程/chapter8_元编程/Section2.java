package com.zzh.Kotlin核心编程.chapter8_元编程;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangzhihao
 * @date 2020/11/29 9:12
 */
public class Section2 {
    public static <A> Map<String, Object> toMap(A a) {
        Field[] fs = a.getClass().getDeclaredFields();
        Map<String, Object> kvs = new HashMap<>();
        Arrays.stream(fs).forEach(f -> {
            f.setAccessible(true);
            try {
                kvs.put(f.getName(), f.get(a));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return kvs;
    }
}
