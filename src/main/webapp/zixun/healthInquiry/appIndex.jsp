<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="UTF-8">
    <title>健康资讯</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="assets/css/gdh/amazeui.min.css"/>
    <link rel="stylesheet" type="text/css" href="assets/css/gdh/commes.css"/>
    <link rel="stylesheet" href="assets/css/gdh/style_hospital.css">
    <link rel="stylesheet" href="assets/css/gdh/style.css">
</head>
<body style="background-color: #f2f2f2!important;">
<!-- Header -->
<header data-am-widget="header" class="am-header am-header-default bgall">
    <h1 class="am-header-title">
        健康资讯
    </h1>
</header>
<!-- Header_ending -->
<div id="post__li">
    <c:forEach items="${page.list}" var="obj">
    <div class="container div_bot">
        <!--用户头像-->
        <div class="header">
            <div><a href="javascript:;"><img class="head_img" src="${obj.smallimg}"/></a></div>
        </div>
        <div class="right_con">
            <a href="appHandler/informationDetails?uidparam=${obj.uid}&uid=${param.uid}&apptoken=${param.apptoken}">
                <div class="demo"  style="text-align: left">
                    <div class="use">
                        <div class="usename am-list-item-hd">
                            <p class="fx_content list_p1">${obj.title}</p><br/>
                            <span class="list_span2"><fmt:formatDate value="${obj.createtime}" pattern="yyyy-MM-dd"></fmt:formatDate></span>
                            <span class="list_span2"><fmt:formatDate value="${obj.createtime}" pattern="HH:mm:ss"></fmt:formatDate></span>
                        </div>
                    </div>
                </div></a>
        </div>
    </div>
    </c:forEach>
    <div style="width: 100%;height: 40px;clear: left;background-color: white!important;">
        <p style="line-height: 40px;text-align: center;font-size: 14px;color: #0087f9">没有更多资讯啦</p>
    </div>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jquery-3.2.0.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/zixun/healthInquiry/appIndex.js"></script>
</body>
</html>