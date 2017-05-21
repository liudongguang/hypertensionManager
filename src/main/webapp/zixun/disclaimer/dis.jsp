<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="UTF-8">
    <title>资讯详情</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="assets/css/gdh/amazeui.min.css"/>
    <link rel="stylesheet" type="text/css" href="assets/css/gdh/commes.css"/>
    <link rel="stylesheet" href="assets/css/gdh/style.css">
</head>
<body>
<div style="padding: 15px 20px;font-family: 微软雅黑">
    <h2>免责声明</h2>
    <p style="font-size: 14px;color: #6f6f6f">${obj.content}</p>
</div>
</body>
</html>