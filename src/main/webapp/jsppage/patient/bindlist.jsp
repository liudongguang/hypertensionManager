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
                    <th>设备SN</th>
                    <th>租借开始时间</th>
                    <th>租借结束时间</th>
                    <th>归还状态</th>
                    <th>记录时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.list}" var="obj">
                    <tr>
                        <td>

                                ${obj.devicesn}</td>
                        <td>
                            <fmt:formatDate value="${obj.zjstart}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </td>
                        <td>
                            <fmt:formatDate value="${obj.zjend}" pattern="yyyy-MM-dd"></fmt:formatDate>

                        </td>
                        <td>
                            <c:if test="${obj.returnstate==1}">
                                借出中
                            </c:if>
                            <c:if test="${obj.returnstate==2}">
                                已归还
                            </c:if>
                            <c:if test="${obj.returnstate==3}">
                                替换
                            </c:if>
                        </td>
                        <td>

                            <fmt:formatDate value="${obj.createtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
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
        <input id="loadDataURL" type="hidden"
               value="/webPatientHandler/patientBindDeviceLogsByUid?patientid=${param.patientid}"/>
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