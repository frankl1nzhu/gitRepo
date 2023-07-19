package com.reflection;

/**
 * ClassName: ClassTest
 * Package: com.reflection
 * Description:
 *
 * @Author Yuzhe ZHU
 * @Create 2023/6/13 13:18
 * Version: 1.0
 */
public class ClassTest {
    /*
    * 获取class类实例的方法
    * */

    public static void main(){
        //1.调用运行时类的属性
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //2.调用运行时类的对象的getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();

        //3.调用Class的静态方法forName(String className)
        String className = "com.reflection.Person.Person()";
       // Class clazz3 = Class.forName(className);
    }
}
