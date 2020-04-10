package com.xzsd.pc.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 这是将实体类中属性值不为空的属性加入到Map，然后将Map返回的工具类
 * zhc
 * 2020年3月27日21:11:14
 */
public class ChangeBeMap {
   public static Map<String,String>changeTtoMap(Object object){
        Map<String,String>map =new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if(null !=getFieldValueByName(fields[i].getName(), object) && fields[i].getName().indexOf("page")== -1){
                 map.put( fields[i].getName(),getFieldValueByName(fields[i].getName(), object).toString());
            }
        }
        return map;
    }
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            return null;
        }
    }
}
