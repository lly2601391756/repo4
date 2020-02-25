<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/20
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <form action="/login" method="post">
    用户名：<input type="text" id="username" name="username" value=""  placeholder="请输入用户名"/>
    密码：<input type="password" id="password" name="password" value=""  placeholder="请输入密码"/>
    验证码：<input type="text" id="code" name="code" value="" placeholder="请输入验证码"/>
    <img src="/code">
    <input type="submit" value="提交"/>
    <input type="reset" value="重置"/>
  </form>
  <a href="register.jsp">用户注册</a>
  </body>
</html>
