<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>日血压图</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" user-scalable="no">
    <meta name="description" content="ECharts, a powerful, interactive charting and visualization library for browser">
    <link rel="stylesheet" href="assets/css/bootstrap3.3.7.css">
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css">
    <link rel="stylesheet" href="assets/css/gdh/amazeui.min.css">
    <link rel="stylesheet" href="assets/css/gdh/appstatistics.css">
</head>
<body>
<input type="hidden" id="basePath" value="${pageContext.request.contextPath }/"/>
<input type="hidden" value="${param.patientid}" id="patientUID"/>
<input type="hidden" value="${param.searchDate}<fmt:formatDate value="${requestScope.reqParam.searchDate}" pattern="yyyy-MM-dd"></fmt:formatDate>" id="currentDateID"/>
<div style="padding: 10px 0;" class="am-u-sm-12 am-margin-bottom am-margin-top">
    <div class="divs1 am-u-sm-12 am-margin-bottom">
        <input type="text" style="border:none;background-color: #fff!important;float: left;display: inline-block;width: 35%"
               placeholder="日期"  id="searchDateID" class="form-control" readonly="readonly"
               value="${param.searchDate}<fmt:formatDate value="${requestScope.reqParam.searchDate}" pattern="yyyy-MM-dd"></fmt:formatDate>"/>
        <img class="am-margin-left imgs1" src="assets/images/date.png" id="dateimgID"
             alt=""/>
        <a href="javascript:;"><img id="listLogID" class="imgs2" src="assets/images/bd.png" alt=""/></a>
        <a href="appstatistics/enterDisplayDayChatForThisDay?patientid=${param.patientid}"><img class="imgs3" src="assets/images/today.png" alt=""/></a>
    </div>
    <div style="width: 100%;border-top: solid 1px #aaa;border-bottom: solid 1px #aaa;padding: 10px 0;"
         class="am-u-sm-12 am-margin-bottom">
        <span class="spans1 am-margin-left"><a href="jsppage/appstatistics/weekpressure.jsp">最近一周</a></span>
        <span class="spans2 am-margin-right"><a href="jsppage/appstatistics/monthpressure.jsp">最近一月</a></span>
    </div>
</div>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="container" style="width: 100%;height:400px"></div>
<script src="assets/js/jquery-3.2.0.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/handlebars.min.js"></script>
<script src="assets/js/amazeui.widgets.helper.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap3.3.7.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/templatemo_script.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/moment.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap-datetimepicker.min.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/layer/layer.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/common.js"></script>
<script language="javascript" type="text/javascript" src="assets/Highcharts/highcharts.js"></script>
<script src="assets/js/jsppage/appstatistics/daypressure.js"></script>
</body>
</html>