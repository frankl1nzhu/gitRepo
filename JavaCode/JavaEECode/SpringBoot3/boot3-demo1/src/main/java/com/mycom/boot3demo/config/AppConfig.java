package com.mycom.boot3demo.config;

import com.alibaba.druid.FastsqlException;
import com.mycom.boot3demo.bean.Pig;
import com.mycom.boot3demo.bean.Sheep;
import com.mycom.boot3demo.bean.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Import(FastsqlException.class)  //给容器中放指定类型的组件，名字默认是全类名
@SpringBootApplication  //配置类

//@EnableConfigurationProperties(Sheep.class)  //导入第三方写好的组件进行属性绑定
//springboot默认只扫描主程序所在的包，如果导入第三方包，即使组件上已经有@component也没用

public class AppConfig {

    @Bean
    public Sheep sheep(){
        return new Sheep();
    }

    @ConfigurationProperties(prefix = "pig")
    @Bean
    public Pig pig(){
        return new Pig();
    }


    @Scope("prototype")  //多实例，每次调用都创建新对象
    @Bean("user02") //替代bean标签，组件在ioc容器中名字默认是方法名user01，可注释修改为user02
    public User user(){
        var user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }
}
