<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="clearfix"></div>
<div class="form-group">
    <button class="btn btn-primary btn-large" ajaxthispage href="/followupManager/msgmodel/addmsgmodel.jsp">新增</button>
</div>

<c:if test="${page.total>0}">
    <div class="table-responsive">
        <table class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <th>标题</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${page.list}" var="obj">
                <tr id="${obj.uid}">
                    <td>${obj.title}</td>
                    <td><fmt:formatDate value="${obj.createtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td>
                        <a class="label label-success" ajaxdel searFormID="subForm" pageNum="${page.pageNum}"
                           href="/sdeyfollowup/delMsgModel?uid=${obj.uid}">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>
<!--
分页开始
-->
<div id="pagesDIV" style="margin: 0 auto"></div>
<input id="pageNum" type="hidden" value="${page.pageNum}"/>
<input id="pageSize" type="hidden" value="${page.pageSize}"/>
<input id="total" type="hidden" value="${page.total}"/>
<input id="pages" type="hidden" value="${page.pages}"/>
<input id="loadDataURL" type="hidden" value="/sdeyfollowup/msgModelList"/>
<input id="searFormID" type="hidden" value="subForm"/>
<!--
分页结束
-->
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/followupManager/msgmodel/msgModelList.js"></script>

