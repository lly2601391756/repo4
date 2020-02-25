<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/24
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    function jump() {
        window.location.href = 'index.jsp';
    }

    setTimeout(jump, 2000);
</script>
<body>
<h1>验证码错误，2s后自动跳转到登录页面</h1>
</body>
</html>
