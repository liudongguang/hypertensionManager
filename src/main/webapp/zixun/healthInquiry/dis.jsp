<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
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
<div id="post__li">
    <div class="container div_bot">
        <div class="right_con1">
            <div class="demo" style="text-align: left">
                <div class="use">
                    <div class="usename am-list-item-hd">
                        <p class="fx_content2 list_p3">${obj.title}</p><br/>
                        <span class="list_span4"><fmt:formatDate value="${obj.createtime}" pattern="yyyy-MM-dd"></fmt:formatDate></span>
                        <span class="list_span3"><fmt:formatDate value="${obj.createtime}" pattern="HH:mm:ss"></fmt:formatDate></span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="background-color: white;padding:0 15px;font-size: 14px">
        ${obj.content}
    </div>
</div>
</body>
<script language="javascript" type="text/javascript" src="assets/js/jquery-3.2.0.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/zixun/healthInquiry/dis.js"></script>
</html>