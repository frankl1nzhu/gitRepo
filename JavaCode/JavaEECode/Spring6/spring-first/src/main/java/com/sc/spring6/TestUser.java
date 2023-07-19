package com.sc.spring6;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUser {

    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserObject(){
        /*在底层中，运用反射创建对象*/
        //加载spring配置文件，创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //获取创建的对象
        User user = (User) context.getBean(User.class);
        System.out.println(user);

        //使用对象调用方法进行测试
        user.add();

        //手动日志
        logger.info("执行调用成功了");
    }


    //反射创建对象
    @Test
    public void testUserObject1() throws Exception {
        //获取类class对象
        Class clazz = Class.forName("com.sc.spring6.User");
        //调用方法创建对象
        User user = (User)clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }

}
