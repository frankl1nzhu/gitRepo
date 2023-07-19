package com.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/*
* 反射被视为动态语言的关键；
* 反射机制允许程序在运行期间借助于Reflection API取得任何类的内部信息，并直接操作任意对象的内部属性和方法*/
public class RefleTest {
    @Test
    public void test1() throws Exception {
        //调用私有构造器
        Class clazz = Person.class;
        Constructor cons = clazz.getDeclaredConstructor(String.class, int.class);
        cons.setAccessible(true);
        Person p1 =  (Person) cons.newInstance("Tom", 12);
        System.out.println(p1);

        //调用私有属性
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(p1, "Jerry");
        System.out.println(nameField.get(p1));
    }

}


