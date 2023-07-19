package com.phone;

public class Phone { //创建关于手机的类
    // 属性
    String name;
    double price;
    //方法
    public void call(){
        System.out.println("Pls call");
    }
    public void message(String mes){
        System.out.println("Pls send messages " + mes);
    }

}

/*
* 属性和局部变量对比
* 属性有默认初始化值，局部变量没有
* 属性有修饰符，局部变量没有
* 作用域：属性为整个类中，局部变量为方法中
* 属性随着对象的创建存储于堆中，局部变量存储于栈中
* */

/*
* 方法声明格式
* ①权限修饰符 + ②返回值类型 + ③方法名 +（形参）+ ④[throws 异常类型]{
* 方法体}
* ①private, public, protected, 缺省
*/