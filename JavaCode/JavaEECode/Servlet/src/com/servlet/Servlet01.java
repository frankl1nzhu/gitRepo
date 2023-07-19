package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName: Servlet01
 * Package: com.servlet
 * Description:
 *
 * @Author Yuzhe ZHU
 * @Create 2023/6/14 15:16
 * Version: 1.0
 */
@WebServlet("/ser01")
//@WebServlet(name = "testservlet", value = "/ser02")
//@WebServlet(name = "ee", value = {"/ser03","/ser04"})

public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello01"); //控制台显示
        resp.getWriter().write("hello02"); //网页显示
    }
}
