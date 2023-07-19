package com.encapsulation.exer;
public class Abstract1 {
    /*
     * abstract抽象类：无法实例化，作用是强迫子类实现其定义的抽象方法，否则会报错
     * 例如，Person1类定义了抽象方法run()，那么，在实现子类Student1的时候，就必须覆写run()方法
     *
     * 好处：不用关心抽象变量的具体子类型
     */
    public static void main(String[] args) {
        Person1 p = new Student1();
        p.run();
    }
}

abstract class Person1 {
    public abstract void run();
}

class Student1 extends Person1 {
    @Override
    public void run() {
        System.out.println("Student.run");
    }

}
