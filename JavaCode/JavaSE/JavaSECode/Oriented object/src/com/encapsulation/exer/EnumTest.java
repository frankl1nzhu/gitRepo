package com.encapsulation.exer;
import java.util.Arrays;

public enum EnumTest {
    SMALL, MEDIUM, LARGE, EXTRA_LARGE;

    public static void main(String[] args) {
        //tostring方法
        System.out.println(EnumTest.SMALL.toString());

        //valueOf方法
        EnumTest ET1 = EnumTest.valueOf(EnumTest.class, "MEDIUM");
        System.out.println(ET1);

        //values方法，获取所有枚举值
        EnumTest[] ET2 = EnumTest.values();
        System.out.println(Arrays.toString(ET2));

    }
}

