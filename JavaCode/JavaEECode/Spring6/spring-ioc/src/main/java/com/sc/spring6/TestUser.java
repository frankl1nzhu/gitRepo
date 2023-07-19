package com.sc.spring6;

import com.sc.spring6.bean.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //根据类型获取接口对应bean, 前提是接口只对应一个实现类
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
        userDao.run();
    }
}
