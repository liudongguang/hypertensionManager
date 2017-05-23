<div id="thisPageDIV">
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <!DOCTYPE html>
    <html>
    <head>
        <base href="${pageContext.request.contextPath }/"/>
        <meta charset="utf-8">
        <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
        <title>设备使用记录</title>
        <meta name="keywords" content=""/>
        <meta name="description" content=""/>
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" href="assets/css/templatemo_main.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css">
    </head>
    <body>
    <input type="hidden" id="basePath" value="${pageContext.request.contextPath }/"/>
    <div>
        <div class="table-responsive">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th>收缩压</th>
                    <th>舒张压</th>
                    <th>心率</th>
                    <th>测量类型</th>
                    <th>血压等级</th>
                    <th>测量时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.list}" var="obj">
                    <tr id="${obj.uid}">
                        <td>${obj.systolicpressure}</td>
                        <td>${obj.diastolicpressure}</td>
                        <td>${obj.pulse}</td>
                        <td>
                            <c:if test="${obj.kkmode==0}">单次</c:if>
                            <c:if test="${obj.kkmode==1}">动态</c:if>
                        </td>
                        <td>
                            <c:if test="${obj.kklevel==0}"><span style="color:#71ddc5">低</span></c:if>
                            <c:if test="${obj.kklevel==1}"><span style="color:#42d1b1">正常</span></c:if>
                            <c:if test="${obj.kklevel==2}"><span style="color:#13c69e">高值</span></c:if>
                            <c:if test="${obj.kklevel==3}"><span style="color:#fc7982">轻度</span></c:if>
                            <c:if test="${obj.kklevel==4}"><span style="color:#fb4c59">中度</span></c:if>
                            <c:if test="${obj.kklevel==5}"><span style="color:#fa1f2f">高度</span></c:if>
                        </td>
                        <td><fmt:formatDate value="${obj.kktime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
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
        <input id="loadDataURL" type="hidden"
               value="/webPatientHandler/getpatientBindDeviceDataByDeviceSNAndPatientID?devicesn=${param.devicesn}&patientid=${param.patientid}"/>
        <input id="searFormID" type="hidden" value="subForm"/>
        <input id="noAjaxPage" type="hidden" value="1"/>
    </div>
    <script language="javascript" type="text/javascript" src="assets/js/jquery-3.2.0.js"></script>
    <script language="javascript" type="text/javascript" src="assets/js/bootstrap3.3.7.js"></script>
    <script language="javascript" type="text/javascript" src="assets/js/layer/layer.js"></script>
    <script language="javascript" type="text/javascript" src="assets/js/main/common.js"></script>
    <script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
    <script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
    <script language="javascript" type="text/javascript" src="assets/js/jsppage/patient/bindlist.js"></script>
    </body>
    </html>
</div>