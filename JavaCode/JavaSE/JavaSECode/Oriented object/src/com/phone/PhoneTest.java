package com.phone;

public class PhoneTest { //Phone类的测试类
    public static void main(String[] args) {
        //创建Phone的对象
        Phone p1 = new Phone();

        //调用内部属性和方法
        p1.name = "iPhone";
        p1.price = 5999.9;
        System.out.println(p1.name + "价格为" + p1.price + "元");

        p1.call();
        p1.message("你是");
    }
}
/*
 * 栈（stack）中：方法+其中定义的变量+变量地址     先进后出，后进先出
 * 堆（heap）中：new 出来的结构，对象和数组，包括对象中的属性         先进先出，后进后出
 * 方法区（method area）：存放类的模板
 * */