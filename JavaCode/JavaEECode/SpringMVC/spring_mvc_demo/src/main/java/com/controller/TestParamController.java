package com.controller;

import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.ref.Reference;

//通过控制器方法获取形参
//只需要在控制器形参位置设置形参，名字和请求参数名字相同即可
//@RequestParam，设置形参和控制器方法的形参绑定
//value:设置和形参绑定的请求参数名
//required：是否必需传输
//defaultValue:默认值，若不传入此名称的形参，则为默认值

//@RequestHeader获取请求头信息
//@CookieValue获取cookie信息
@Controller
public class TestParamController {
    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "username", required = true, defaultValue = "admin") String username456,
                           String password,
                           @RequestHeader("Referer") String referer,
                           @CookieValue("JSESSIONID")String jsessionid) {
         System.out.println("username=" + username456 + " password=" + password);
        return "success";
    }

    //通过实体类获取请求参数
    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }
}
