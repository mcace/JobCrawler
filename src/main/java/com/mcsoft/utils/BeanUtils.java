package com.mcsoft.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/**
 * 实体类对象操作工具类
 * Created by Mc on 2017/12/14.
 */
public class BeanUtils {
    /**
     * 将源对象中非null字段拷贝到目标对象
     *
     * @param src    源对象
     * @param target 目标对象
     */
    public static void copyNotNullField(Object src, Object target) {
        copy(src, target, getNotNullFields(src));
    }

    /**
     * 拷贝对象，只拷贝相同类的对象，且不能拷贝父类的变量
     *
     * @param src        待拷贝对象
     * @param target     拷贝目标对象
     * @param properties 拷贝的属性列表
     */
    public static void copy(Object src, Object target, String[] properties) {
        Class srcClass = src.getClass();
        //判断两个对象是不是同一类或有继承关系
        if (null != srcClass && srcClass != target.getClass()) {
            return;
        }
        for (String property : properties) {
            try {
                Field field = src.getClass().getDeclaredField(property);
                if (null == field) continue;
                field.setAccessible(true);
                field.set(target, field.get(src));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取一个对象的null变量名集合，只能获取当前类的变量，不能获取到父类的变量
     *
     * @param src 要查找null变量的对象
     * @return 值为null的变量名集合
     */
    public static String[] getNotNullFields(Object src) {
        HashSet<String> result = new HashSet<>();
        if (src == null) return new String[]{};
        Field[] fields = src.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (null != field.get(src)) {
                    result.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        String[] emptyStrings = new String[result.size()];
        return result.toArray(emptyStrings);
    }

    /**
     * 判断两个对象的实例变量是否一一相等，只能判断当前类的变量，不能判断父类变量是否相等
     *
     * @param obj1 对象1
     * @param obj2 对象2
     * @return 对象的实例变量是否一一相等
     */
    public static boolean equals(Object obj1, Object obj2) {
        Class obj1Class = obj1.getClass();
        //判断两个对象是不是同一类
        if (null != obj1Class && obj1Class != obj2.getClass()) {
            return false;
        }
        Field[] fields1 = obj1.getClass().getDeclaredFields();
        Field[] fields2 = obj2.getClass().getDeclaredFields();
        if (!Arrays.equals(fields1, fields2)) {
            return false;
        }
        for (Field field : fields2) {
            try {
                field.setAccessible(true);
                Object value1 = field.get(obj1);
                Object value2 = field.get(obj2);
                if (value1 == null ? value2 != null : !value1.equals(value2)) return false;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * 用默认的键值对将对象的实例变量中为null值的赋予默认值
     *
     * @param src 要赋值的对象
     */
    public static void setNullToDefault(Object src) {
        setNullToDefault(src, Constants.DEFAULT_VALUES_MAP);
    }

    /**
     * 将对象的实例变量中为null值的赋予默认值
     *
     * @param src              要赋值的对象
     * @param defaultValuesMap 默认值键值对，可以使用{@link Constants#DEFAULT_VALUES_MAP}
     */
    public static void setNullToDefault(Object src, Map<Class, Object> defaultValuesMap) {
        if (null == src || null == defaultValuesMap || defaultValuesMap.size() == 0) {
            return;
        }
        Field[] fields = src.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (null == field.get(src)) {
                    field.set(src, defaultValuesMap.get(field.getType()));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
