package com.encapsulation.exer;

/**
 * ClassName: InterfaceClass
 * Package: com.exer
 * Description:
 *
 * @Author Yuzhe ZHU
 * @Create 2023/6/12 13:39
 * Version: 1.0
 */
public class InterfaceClass {
    /*
    * 如果一个抽象类中没有实例字段，全部是抽象方法或静态字段，且静态字段须为final，则为接口
    * 一个类只能继承自另一个类，但是可是实现多个interface*/
}
interface Person2 {
    void run();
    String getName();
}
//implements关键字用于引用接口，extends用于接口继承其他接口
class Student2 implements Person2 {
    private String name2;

    public Student2(String name) {
        this.name2 = name;
    }
    @Override
    public void run() {
        System.out.println(this.name2 + " run");
    }

    @Override
    public String getName() {
        return this.name2;
    }
}
