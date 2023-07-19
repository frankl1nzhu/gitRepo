package com.mycom.boot3demo.config;

import com.mycom.boot3demo.bean.Cat;
import com.mycom.boot3demo.bean.Dog;
import com.mycom.boot3demo.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class AppConfig2 {

    //若存在该类，则在容器中放一个Cat组件，名cat01
    @ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")
    @Bean
    public Cat cat01(){
        return new Cat();
    }

    //若不存在该类，则在容器中放一个Dog组件，名dog01
    @ConditionalOnMissingClass(value = "com.alibaba.druid.FastsqlException")
    @Bean
    public Dog dog01(){
        return new Dog();
    }

    //若存在Dog组件，则在容器中放一个User组件
    @ConditionalOnBean(value = Dog.class)
    @Bean
    public User zhangsan(){
        return new User();
    }

    //若不存在Dog组件，则在容器中放另一个User组件
    @ConditionalOnMissingBean(value = Dog.class)
    @Bean
    public User lisi(){
        return new User();
    }
}