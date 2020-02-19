package com.chinasoft.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Hello implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
        PrintWriter writer = resp.getWriter();
        writer.println("hello");
        writer.close();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
