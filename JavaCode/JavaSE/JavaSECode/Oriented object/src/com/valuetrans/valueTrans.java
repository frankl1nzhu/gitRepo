package com.valuetrans; /**
 * ClassName: valuetrans.valueTrans
 * pack.Package: PACKAGE_NAME
 * Description:
 *
 * @Author Yuzhe ZHU
 * @Create 2023/6/9 13:47
 * Version: 1.0
 */

/**
 * 值传递机制：局部变量中-->基本数据类型传数据值，引用数据类型传地址
 */
public class valueTrans {
    public static void main(String[] args) {
        //基本数据类型
        int m = 10;
        int n = m;
        m++;
        System.out.println("m =  " + m + ", n = " + n);

        //引用数据类型
        //1. 数组
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = a1;
        a1[0] ++;
        System.out.print(a1[0] + " ");
        System.out.println(a2[0]);

        //2.类
        order o1 = new order();
        o1.orderID = 123;
        order o2 = o1;
        o1.orderID ++;
        System.out.println(o2.orderID);
    }

    //交换两个元素值
    //注意不能：public void swap(int i, int j){...}
    public void swap(int[] arr, int i, int j ){ //i，j为索引
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
class order{
    int orderID;
}
