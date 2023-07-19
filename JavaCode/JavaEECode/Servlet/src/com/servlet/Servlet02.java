package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName: Servlet02
 * Package: com.servlet
 * Description:
 *
 * @Author Yuzhe ZHU
 * @Create 2023/6/14 15:40
 * Version: 1.0
 */
@WebServlet("/ser02")

public class Servlet02 extends HttpServlet {

    /*
     * 服务方法，系统方法，服务器自动调用
     * 可执行多次
     * */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("可以服务...");
    }

    /*销毁方法，服务器自动调用
    * 服务器关闭或应用程序停止时关闭
    * 只会执行一次
    * */
    @Override
    public void destroy() {
        System.out.println("销毁...");
    }

    /*
    * 初始化方法
    * 系统方法：服务器自动调用
    * 当请求到达servlet容器时，servlet容器会判断改servlet对象是否存在，如果不存在则创建实例并初始化
    * 该方法只会执行一次
    * */
    @Override
    public void init() throws ServletException {
        System.out.println("实例创建...");
    }
}
