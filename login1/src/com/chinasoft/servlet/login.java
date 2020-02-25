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

@WebServlet("/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        ShearCaptcha captcha = (ShearCaptcha) session.getAttribute("captcha");
        if(!captcha.verify(code)){
            req.getRequestDispatcher("/FailIdentifyCode.jsp").forward(req,resp);
        }else {
            jdbcTempInter inter = new jdbcTempImpl();
            boolean getlogin = inter.getlogin(username, password);
            if (getlogin) {
                req.getRequestDispatcher("/SuccessServlet.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/FailServlet.jsp").forward(req, resp);
            }
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
