package com.spring.aop.xmlanno;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        int result = a + b;
        System.out.println("方法内部 result = "+result);
        //测试异常
        //int i = 1/0;
        return a + b;
    }
    @Override
    public int sub(int a, int b) {
        int result = a - b;
        System.out.println("方法内部 result = "+result);
        return a - b;
    }
    @Override
    public int mul(int a, int b) {
        double result = a * b;
        System.out.println("方法内部 result = "+result);
        return a * b;
    }
    @Override
    public int div(int a, int b) {
        double result = a - b;
        System.out.println("方法内部 result = "+result);
        return a / b;
    }
}
