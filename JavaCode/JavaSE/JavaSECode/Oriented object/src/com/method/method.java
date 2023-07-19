package com.method;

/**
 * ClassName: method.method
 * pack.Package: PACKAGE_NAME
 * Description:
 *
 * @Author Yuzhe ZHU
 * @Create 2023/6/9 13:20
 * Version: 1.0
 */
/*
 * 方法重载（overload）：同类中的同名方法，参数列表（个数，类型或顺序）不同，和参数名称，返回值无关
 * ...表示可变参数，但在有同名方法时优先使用确定个数的方法
 */
public class method {
    public void a(int ... nums){
        System.out.println("111");
    }
    //可变形参与形参为数组冲突，编译后认为int ... nums 与 int[] nums 相同
    //public void a(int[] nums){};  报错
    public void a(int nums){
        System.out.println("222");
    }
    public void a(int i, int j){
        System.out.println("333");
    }

    //有包括可变形参的多个参数时，可变形参需放在参数列表最后
    //一个方法的形参中只能包括一个可变参数
    public void a(double i, int ...j){  //而不能public void a(int ...i, int j){}
        System.out.println("444");
    }
}

