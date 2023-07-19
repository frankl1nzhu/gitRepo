package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
public class TestScopeController {
    @RequestMapping("/test/mav")
    public ModelAndView TestMAV() {
        /*
        * Model:向请求域中共享数据
        * View：设计逻辑视图实现页面跳转
        * */
        ModelAndView mav = new ModelAndView();
        //向请求域中共享数据
        mav.addObject("testRequestScope", "hello,mav");
        //设置逻辑视图
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "hello,model");
        return "success";
    }

    //session生效为浏览器开启到关闭期间
    @RequestMapping("/test/session")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    //application生效为服务器开启到关闭
    @RequestMapping("/test/application")
    public String testApplication(HttpSession session ) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","hello,application");
        return "success";
    }
}
