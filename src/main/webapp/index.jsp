<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>

<head>
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="utf-8">
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
    <title>山大二院随访系统</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width">
    <link type="text/css" rel="stylesheet" href="assets/css/login.css">
</head>
<body>

<div class="login">
    <div class="logo"><img src="assets/images/logo.png"></div>
    <div id="darkbannerwrap"></div>
    <div class="login_content">
        <div style="text-align:center; margin:48px 0 15px 0"><img src="assets/images/L-header.png"></div>
        <form action="sdeyfollowup/login" method="post">
            ${requestScope.error}
            <label>用户名</label>
            <input name="username" required type="text" value="admin">

            <label>密码</label>
            <input name="pass" required type="password" value="admin123">

            <input value="登录" style="width:100%; margin-top:40px;" type="submit" >
            <!--<hr class="hr20">-->
            <!-- 帮助 <a onClick="alert('请联系管理员')">忘记密码</a> -->
        </form>

    </div>
    <div class="copyright">Copyright © 2017 山东大学第二医院网络医院</div>
</div>
</body>
</html>