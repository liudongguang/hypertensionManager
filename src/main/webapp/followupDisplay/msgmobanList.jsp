<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="utf-8">
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
    <title>短信模版</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="assets/css/templatemo_main.css">
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<input type="hidden" id="basePath" value="${pageContext.request.contextPath }/"/>
<c:if test="${page.total>0}">
    <form id="subForm" action="sdeyfollowup/sendMsgByPationtsInfo" method="post">
        <input type="hidden"  id="msgcontentID" name="msgContent" />
        <input type="hidden"  id="msguidID" name="msgid" />
        <c:forEach items="${paramValues}" var="item">
            <input name="${item.key}" value="${item.value[0]}" type="hidden"/>
        </c:forEach>
    </form>
 <button id="sendMSGBTID" class="btn btn-primary btn-large" style="margin: 20px">发送</button>
    <div class="table-responsive">
        <table class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <td></td>
                <th>标题</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="obj">
                <tr id="tr_${obj.uid}">
                    <td><input value="${obj.uid}" type="radio" name="msguid"/></td>
                    <td id="td_${obj.uid}" mtips="${obj.msgcontent}">${obj.title}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>

<!--
分页开始
-->
<div id="pagesDIV" style="margin: 0 auto">
</div>
<input id="pageNum" type="hidden" value="${page.pageNum}"/>
<input id="pageSize" type="hidden" value="${page.pageSize}"/>
<input id="total" type="hidden" value="${page.total}"/>
<input id="pages" type="hidden" value="${page.pages}"/>
<input id="loadDataURL" type="hidden" value="/sdeyfollowup/getMsgModels"/>
<input id="searFormID" type="hidden" value="subForm"/>
<input id="noAjaxPage" type="hidden" value="1"/>
<!--
分页结束
-->
<script language="javascript" type="text/javascript" src="assets/js/jquery-3.2.0.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap3.3.7.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/templatemo_script.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/layer/layer.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/common.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/followupDisplay/msgmobanList.js"></script>
</body>

