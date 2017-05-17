<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="A simple jQuery image cropping plugin.">
    <meta name="keywords"
          content="device search">
    <meta name="author" content="Fengyuan Chen">
    <title>Cropper</title>
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="assets/cropper/font-awesome.min.css">
    <link rel="stylesheet" href="assets/cropper/tether.min.css">
    <link rel="stylesheet" href="assets/css/bootstrap3.3.7.css">
</head>
<body>
<div style="margin: 20px;">
    <input type="hidden" id="basePath" value="${pageContext.request.contextPath }/"/>
    <div class="table-responsive">
        <button id="sureBT" type="button" style="margin-bottom: 10px;" class="btn btn-default pull-right">确定
        </button>
        <table class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <th></th>
                <th>sn</th>
                <th>名称</th>
                <th>激活状态</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="obj">
                <tr checkTR="${obj.uid}">
                    <td><input type="radio" name="deviceid" id="deviceid${obj.uid}" value="${obj.uid}" mingcheng="${obj.alias}" deviceSN="${obj.sn}"/></td>
                    <td>${obj.sn}</td>
                    <td>${obj.alias}</td>
                    <td enable="${obj.enable}">
                        <c:if test="${obj.enable==1}">是</c:if>
                        <c:if test="${obj.enable==2}">否</c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <!--分页开始-->
    <div id="pagesDIV" style="margin: 0 auto"></div>
    <input id="pageNum" type="hidden" value="${page.pageNum}"/>
    <input id="pageSize" type="hidden" value="${page.pageSize}"/>
    <input id="pages" type="hidden" value="${page.pages}"/>
    <input id="total" type="hidden" value="${page.total}"/>
    <input id="loadDataURL" type="hidden" value="/deviceHandler/deviceListForSelect"/>
    <input id="searFormID" type="hidden" value="subForm"/>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jquery-3.2.0.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap3.3.7.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/layer/layer.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/common.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jsppage/device/selectdevicelist.js"></script>
</body>
</html>