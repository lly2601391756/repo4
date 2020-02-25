package com.chinasoft.servlet;

import cn.hutool.captcha.ShearCaptcha;
import com.chinasoft.dao.jdbcTempImpl;
import com.chinasoft.dao.jdbcTempInter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registerAjax")
public class registerAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if("name".equals(action)){
            String name = request.getParameter("name");
            System.out.println("registerAjax:name="+name);
            jdbcTempInter tempInter = new jdbcTempImpl();
            boolean b = tempInter.RegisterUsername(name);
            if(b){
                response.getWriter().write("true");
            }
        }
        if("code".equals(action)){
            String code = request.getParameter("code");
            HttpSession session = request.getSession();
            ShearCaptcha captcha = (ShearCaptcha) session.getAttribute("captcha");
            if(captcha.verify(code)){
                response.getWriter().write("true");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
