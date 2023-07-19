package com.caogao;

public class Polymorphisme {
    public static void main(String[] args) {
        People p=new Stu();
        p.eat();
        //p.study(); 报错，即多态定义时只能用父类中已有的方法，并按子类中内容运行
        //调用特有的方法
        Stu s=(Stu)p;
        s.study();
        //((Stu) p).study();
        People p1 = new Teachers();
        p1.eat();
    }
}
class People{
    public void eat(){
        System.out.println("吃饭");
    }
}
class Stu extends People{
    @Override
    public void eat(){
        System.out.println("吃水煮肉片");
    }
    public void study(){
        System.out.println("好好学习");
    }
}
class Teachers extends People{
    @Override
    public void eat(){
        System.out.println("吃樱桃");
    }
    public void teach(){
        System.out.println("认真授课");
    }
}
