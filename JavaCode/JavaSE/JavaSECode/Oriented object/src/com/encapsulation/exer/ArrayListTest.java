package com.encapsulation.exer;

import java.util.ArrayList;

/*
* 泛型ArrayList写法：ArrayList<类> 名称 = new ArrayList<类>（）；
* 可向上转型为 List<类>， 但需要保证同类
* */
class ALT {
    ArrayList<String> stringlist = new ArrayList<>();
    ArrayList<Float> floatList = new ArrayList<Float>();
    ArrayList<Integer> intList = new ArrayList<>();

}

public class ArrayListTest{
    public static void main(String[] args) {
        ALT test1 = new ALT();
    }
}
