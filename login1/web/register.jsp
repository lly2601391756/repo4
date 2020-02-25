<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/22
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script>
    function r_submit() {
        var flag = true;
        var name = $("#name");
        var pass1 = $("#pass1");
        var pass2 = $("#pass2");
        var code = $("#code");
        if(name.val() == "" || name.val() ==null){
            alert("用户名不能为空");
            flag = false;
            return;
        }
        if(pass1.val() =="" || pass1.val()==null || pass2.val()=="" || pass2.val()==null){
            alert("密码不能为空");
            flag = false;
            return;
        }
        if(pass1.val() != pass2.val()){
            alert("两次输入的密码不一样");
            pass1.val("");
            pass2.val("");
            flag = false;
            return;
        }
        if(code.val()=="" || code.val()==null){
            alert("请输入验证码");
            flag = false;
            return;
        }
        $.post("/registerAjax",{
            action:"name",
            name:name.val()
        },function(data,status){
            if(data != "true"){
                alert("用户名已存在，请重新输入");
                window.location.href="register.jsp";
            }
        });
        $.post("/registerAjax",{
            action:"code",
            code:code.val()
        },function (data,status) {
            if(data != "true"){
                alert("验证码错误");
                window.location.href="register.jsp";

            }
        });
        if(flag){
            $("#form").submit();
        }
    }

</script>
<body>
<form action="/register" id="form" method="post">
    用户名：<input type="text" id="name" name="name" value=""  placeholder="请输入用户名"/>
    密码：<input type="password" id="pass1" name="pass1" value="" placeholder="请输入密码"/>
    确认密码：<input type="password" id="pass2" name="pass2" value="" placeholder="请再次输入密码"/>
    验证码：<input type="text" id="code" name="code" value=""  placeholder="请输入验证码"/>
    <img id="img" name="img" src="/code">
    <input type="button" value="注册" onclick="r_submit()"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>
