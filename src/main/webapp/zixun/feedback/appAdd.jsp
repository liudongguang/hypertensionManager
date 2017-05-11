<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html class="no-js">
<head>
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>意见反馈</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="assets/css/gdh/amazeui.min.css">
    <link rel="stylesheet" href="assets/css/gdh/app.css">
    <link rel="stylesheet" href="assets/css/gdh/style_hospital.css">
    <link rel="stylesheet" href="assets/css/gdh/style.css">
</head>
<body>
<!-- Header -->
<%--<header data-am-widget="header" class="am-header am-header-default bgall">
    <h1 class="am-header-title">
        意见反馈
    </h1>
</header>--%>
<!-- Header_ending -->
<!--内容列表开始-->
<div class="am-list-news-bd pdg">
    <input type="hidden" id="basePath" value="${pageContext.request.contextPath }/"/>
    <form id="subForm" action="appHandler/saveAppfeedback" class="am-form text_main" method="post" enctype="multipart/form-data">
        <input type="hidden" name="pici" value="${pici}" id="piciID">
        <div class="clearfix"></div>
        <div class="am-form-group">
            <label class="msg_label" style="">意见反馈：</label>
            <textarea style="border-radius: 3px" class="" rows="6" required errInfo="意见反馈必填！" name="textContent"></textarea>
        </div>
        <div>
            <div id="imgsDIVID"></div>
            <div class="am-form-group am-form-file am-fl up_all">
                <button type="button" class="am-btn am-btn-default am-radius am-text-x up_plus">
                    <img style="width: 35px;height: 35px;" src="assets/images/plus.png" alt=""/></button>
                <input id="doc-form-file" type="file" multiple="multiple" accept="image/jpeg,image/png">
            </div>
           <%-- <div id="init" class="am-form-group am-form-file am-fl up_all">
                <button type="button" class=" am-btn am-btn-default am-radius am-text-x up_plus">
                    <img style="width: 35px;height: 35px;" src="assets/images/minus.png" alt=""/></button>
                <!--<input  type="file" multiple>-->
            </div>--%>
        </div>
        <div style="width: 100%;height: 1px;clear: left"></div>
        <div class="am-form-group">
            <label class="msg_label" style="">联系方式：</label>
            <input style="border-radius: 3px" placeholder="手机/QQ（必填）" type="text" required errInfo="手机/QQ（必填）" name="lxfs"/>
            <input style="border-radius: 3px"  type="hidden" value="${param.registphone}" required errInfo="请填写注册手机号" name="registphone"/>
        </div>
        <input type="hidden" value="" name="imgsContent" id="imgsContentID"/>
    </form>
    <a href="javascript:void(0)"  class="am-u-sm-12 am-margin-top-sm">
        <button id="subBT" type="button" class="am-btn am-btn-primary am-radius am-u-sm-12 mb20 btn_bg" style="background-color: #0099b9">提交</button>
    </a>
</div>
<div class="clearfix"></div>
<!--内容列表结束-->
<script language="javascript" type="text/javascript" src="assets/js/jquery-3.2.0.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/layer/layer.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/common.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/zixun/feedback/appAdd.js"></script>
</body>
</html>