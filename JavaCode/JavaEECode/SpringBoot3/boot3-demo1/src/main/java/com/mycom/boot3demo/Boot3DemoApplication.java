package com.mycom.boot3demo;

import com.mycom.boot3demo.bean.Person;
import com.mycom.boot3demo.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Boot3DemoApplication {

    public static void main(String[] args) {

        //java10：局部变量类型自动判断
        var ioc = SpringApplication.run(Boot3DemoApplication.class, args);

        Person person = ioc.getBean(Person.class);
        System.out.println(person);





    }
}
