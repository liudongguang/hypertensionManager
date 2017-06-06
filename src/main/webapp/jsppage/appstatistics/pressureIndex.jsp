<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html class="no-js">
<head>
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>心电记录</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="assets/css/bootstrap3.3.7.css">
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css">
    <link rel="stylesheet" href="assets/css/gdh/amazeui.min.css">
    <link rel="stylesheet" href="assets/css/gdh/appstatisticsIndex.css">
</head>
<body>
<input type="hidden" id="basePath" value="${pageContext.request.contextPath }/"/>
<div class="am-margin-top-lg">
    <input type="hidden" value="${param.patientid}" id="patientUID"/>
    <div class="divs1 am-u-sm-12 am-margin-bottom">
        <input type="text" style="border:none;background-color: #fff!important;float: left;display: inline-block;width: 35%"
               placeholder="日期"  id="searchDateID" class="form-control" readonly="readonly"
               value="<fmt:formatDate value="${obj.lastDate}" pattern="yyyy-MM-dd"></fmt:formatDate>"/>
        <img class="am-margin-left imgs1" src="assets/images/date.png" id="dateimgID"
             alt=""/>

        <a href="appstatistics/enterDisplayDayChat?patientid=${param.patientid}&searchDate=<fmt:formatDate value="${obj.lastDate}" pattern="yyyy-MM-dd"></fmt:formatDate>"><img style="width: 32px;float: right;margin-right: 20px"
                                                             src="assets/images/xy.png" alt=""/></a>
        <a href="appstatistics/indexForToday?patientid=${param.patientid}"><img style="width: 33px;float: right;margin-right: 20px"
                                                             src="assets/images/today.png" alt=""/></a>
    </div>
    <div class="divs2 am-u-sm-12 am-margin-bottom">
        <span class="spans1 am-margin-left"><a href="appstatistics/enterweekpressure?patientid=${param.patientid}">最近一周</a></span>
        <span class="spans2 am-margin-right"><a href="jsppage/appstatistics/monthpressure.jsp">最近一月</a></span>
    </div>
    <!--内容列表开始-->
    <div class="am-margin-top">
        <table class="am-table text_main" style="border-top: solid 1px #aaa;border-bottom: solid 1px #aaa;">
            <thead>
            <tr style="height: 60px;line-height: 60px;text-align: center;font-size: 18px;">
                <td>时间</td>
                <td>收缩压</td>
                <td>舒张压</td>
                <td>心率</td>
                <td>等级</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${obj.measureData}" var="obj">
                <tr style="height: 60px;line-height: 60px;text-align: center">
                    <td><fmt:formatDate value="${obj.kktime}" pattern="HH:mm:ss"></fmt:formatDate></td>
                    <td>${obj.systolicpressure}</td>
                    <td>${obj.diastolicpressure}</td>
                    <td>${obj.pulse}</td>
                    <td><c:if test="${obj.kklevel==0}"><span style="color:#71ddc5">低</span></c:if>
                        <c:if test="${obj.kklevel==1}"><span style="color:#42d1b1">正常</span></c:if>
                        <c:if test="${obj.kklevel==2}"><span style="color:#13c69e">高值</span></c:if>
                        <c:if test="${obj.kklevel==3}"><span style="color:#fc7982">轻度</span></c:if>
                        <c:if test="${obj.kklevel==4}"><span style="color:#fb4c59">中度</span></c:if>
                        <c:if test="${obj.kklevel==5}"><span style="color:#fa1f2f">高度</span></c:if></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--内容列表结束-->
</div>
<script src="assets/js/jquery-3.2.0.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/handlebars.min.js"></script>
<script src="assets/js/amazeui.widgets.helper.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap3.3.7.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/templatemo_script.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/moment.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap-datetimepicker.min.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/layer/layer.js"></script>
<script src="assets/js/jsppage/appstatistics/pressureIndex.js"></script>
</body>
</html>