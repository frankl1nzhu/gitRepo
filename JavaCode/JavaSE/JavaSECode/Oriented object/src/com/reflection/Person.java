package com.reflection;

/**
 * ClassName: Person
 * Package: com.reflection
 * Description:
 *
 * @Author Yuzhe ZHU
 * @Create 2023/6/13 11:09
 * Version: 1.0
 */
public class Person {
    private String name;
    public int age;

    //构造器
    public Person(){

    }
    public Person(int age){
        this.age = age;
    }
    private Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
