package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
* 查询所有用户信息: /user -->get
* 根据id查询用户信息：/user/1 -->get
* 添加用户信息：/user -->post
* 更新用户信息：/user -->put
* 删除用户信息：/user/1 -->delete
*/

/*注意浏览器目前只能发送get和post请求
* 若要发送delete和put请求：1.在web.xml中配置请求过滤器
*                       2.当前请求为post，传输请求参数_method
* */

/**
 * @author Franklin
 */
@Controller
public class TestRestController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUsers(){
        System.out.println("查询所有用户信息-->/user-->get");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("根据id查询用户信息-->/user/"+id+"-->get");
        return "success";
    }

    @RequestMapping(value = "/user",method =RequestMethod.POST)
    public String insertUser(){
        System.out.println("添加用户信息-->/user-->post");
        return "success";
    }

    @RequestMapping(value = "/user",method =RequestMethod.PUT)
    public String updateUser(){
        System.out.println("修改用户信息-->/user-->put");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method =RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("删除用户信息-->/user-->delete");
        return "success";
    }

}
