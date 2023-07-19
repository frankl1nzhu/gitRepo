package com.controller;

import com.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/*
* @RequestBody:读取HTTP请求的内容，将json格式的请求参数转化为java对象
* 用法：1、导入jackson依赖
*      2、springmvc中配置注解驱动
*      3、在处理请求的控制器方法形参部分，直接设置要转化的java类
*
*
* @ResponseBody：将所标识的控制器方法的返回值作为响应报文的响应体响应到服务器，用来响应浏览器json格式的数据
* 用法：1、导入jackson依赖
*      2、springmvc中配置注解驱动
*      3、将需要转化为json字符串的java对象直接作为控制器方法返回值*/
public class TestAjaxController {
    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("requestBody:" + requestBody);
        System.out.println("id:" + id);
        response.getWriter().write("hello,axios");
    }

    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public List<User> testResponseBodyJson(){
        User user1 = new User(1001, "admin1", "123456", 20, "男");
        User user2 = new User(1002, "admin2", "123456", 20, "男");
        User user3 = new User(1003, "admin3", "123456", 20, "男");
        List<User> list = Arrays.asList(user1, user2, user3);
        return list;
    }
}
