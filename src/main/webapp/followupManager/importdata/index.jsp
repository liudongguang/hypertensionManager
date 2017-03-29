<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="clearfix"></div>
${importErroMsg}
<form class="form-inline" action="sdeyfollowup/getOneMonthHisChuYuanPatient">
    <div class="pull-right" style="margin-bottom: 10px;">
        <div class="form-group">
            <select id="fprqID" class="form-control">
                <option value="">--- <c:if test="${fn:length(beforDates)==0}">无可分配日期</c:if>
                    <c:if test="${fn:length(beforDates)>0}">请选择</c:if>----
                </option>
                <c:forEach items="${beforDates}" var="obj">
                    <option value="${obj}">[${obj}]</option>
                </c:forEach>
            </select>
            <button class="btn btn-primary btn-large" ajaxthispage href="/sdeyfollowup/getOneMonthHisChuYuanPatient">获取
            </button>
        </div>
    </div>
</form>
<div class="clearfix"></div>
<div class="table-responsive">

    <table class="table table-striped table-hover table-bordered">
        <thead>
        <tr>
            <th>已导入月份</th>
            <th>导入时间</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${page.list}" var="obj">
            <tr id="${obj.uid}">
                <td>${obj.importdatestr}</td>
                <td><fmt:formatDate value="${obj.createtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
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
<input id="total" type="hidden" value="${page.total}"/>
<input id="pages" type="hidden" value="${page.pages}"/>
<input id="loadDataURL" type="hidden" value="/sdeyfollowup/enterOneMonthHisChuYuanPatient"/>
<input id="searFormID" type="hidden" value="subForm"/>
<!--
分页结束
-->
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/followupManager/importdata/index.js"></script>


