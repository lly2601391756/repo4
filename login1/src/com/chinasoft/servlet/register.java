package com.chinasoft.servlet;

import com.chinasoft.dao.jdbcTempImpl;
import com.chinasoft.dao.jdbcTempInter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String password  = request.getParameter("pass1");
        jdbcTempInter tempInter = new jdbcTempImpl();
        tempInter.Register(name,password);
        response.getWriter().write("注册成功");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
