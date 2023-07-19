package com.ui;

import com.bean.User;

import java.util.ResourceBundle;
import java.util.Scanner;

public class BaseClass {
    protected static Scanner input = new Scanner(System.in);
    protected static User currUser; //当前登录用户对象
    private static ResourceBundle r = ResourceBundle.getBundle("com.res.r");
    public static String getString(String key){
        return r.getString(key);
    }
    public static void println(String s){
        System.out.println(s);
    }
}
