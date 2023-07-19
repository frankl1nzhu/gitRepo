package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/protal")
public class ProtalController {

    //method唯一需要post：表单提交；剩下都是get
    //method为数组类型，可匹配多个请求方式
    //value为数组类型，可以匹配多个请求路径

    //有@Getmapping,@Postmapping等直接确定method的注解

/*
    params属性:
    "param":请求参数必须携带param参数
    "!param":请求参数必须不携带param参数
    "param=value":必须携带param参数且=value
    "param!=value":可不携带参数，如果携带必须不等于value
*/
    //headers属性为请求头参数，用法与params相同

    //特殊字符：可用于路径中
    //？代表任意单个字符
    //*代表0或多个字符
    //**表示任意层数的任意目录，必须使用/**/xxxx的方式，即要有最终目录
    @RequestMapping(value = {"/demo1","/demo2"},
            method = {RequestMethod.GET,RequestMethod.POST})
    public String test01(){
        return "index";
    }

    //占位符
    @RequestMapping("/abc/{username}/{id}")
    public String testRest(@PathVariable String username, @PathVariable Integer id){
        System.out.println("username=" + username + "id=" + id);
        return "success";
    }


}
