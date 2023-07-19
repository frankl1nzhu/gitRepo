package com.recursive;
/**
 * ClassName: recursive.recursive
 * pack.Package: PACKAGE_NAME
 * Description:
 *
 * @Author Yuzhe ZHU
 * @Create 2023/6/9 14:48
 * Version: 1.0
 */
public class recursive {
    //终止条件
    /** 往已知上靠
     * 已知数列：f(0) = 1, f(1) = 4
     * f(n+2) = 2*f(n+1) + f(n), 求f(10)
     */

    public static void main(String[] args) {
        recursive f = new recursive();
        System.out.println(f.f1(10));
        System.out.println(f.f2(10));
    }

    public int f1(int n){
        if (n==0){
            return 1;
        } else if (n==1){
            return 4;
        } else {
            return 2 * f1(n-1) + f1(n-2);
        }
    }

    /**
     * 已知f(20) = 1, f(21) = 4, f(n+2) = 2*f(n+1)+f(n)
     * n为大于0的整数，求f(10)
     */
    public int f2(int n){
        if (n==20){
            return 1;
        } else if (n==21){
            return 4;
        } else {
            return f2(n+2) - 2 * f2(n+1);
        }
    }
}
