<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="table-responsive">
    <table class="table table-striped table-hover table-bordered">
        <thead>
        <tr>
            <th><input type="checkbox" id="checkAllCheckBox"> </th>
            <th>姓名</th>
            <th>收缩压</th>
            <th>舒张压</th>
            <th>心率</th>
            <th>测量时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="obj">
            <tr id="${obj.uid}">
                <td></td>
                <td></td>
                <td>${obj.systolicpressure}</td>
                <td>${obj.diastolicpressure}</td>
                <td>${obj.pulse}</td>
                <td><fmt:formatDate value="${obj.kktime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!--
分页开始
-->
<div id="pagesDIV" style="margin: 0 auto"></div>
<input id="pageNum" type="hidden" value="${page.pageNum}"/>
<input id="pageSize" type="hidden" value="${page.pageSize}"/>
<input id="pages" type="hidden" value="${page.pages}"/>
<input id="total" type="hidden" value="${page.total}"/>
<input id="loadDataURL" type="hidden" value="/sdeyfollowup/getOutHosMembers"/>
<input id="searFormID" type="hidden" value="subForm"/>
<!--
分页结束
-->
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>

