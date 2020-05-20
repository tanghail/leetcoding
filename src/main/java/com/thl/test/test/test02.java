package com.thl.test.test;

import com.thl.test.scanAnnotationUtils.Person;

import java.lang.reflect.Field;

/**
 * 测试在field的set（object， object）的使用
 */


public class test02 {
    public static void main(String[] args) {
        Person haitang = new Person("haitang", 24, 1);
        try {
            Field fName = haitang.getClass().getDeclaredField("name");
            fName.setAccessible(true);
            fName.set(haitang, "hailang");

            System.out.println(haitang.getName());
            System.out.println(fName.get(haitang));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}

