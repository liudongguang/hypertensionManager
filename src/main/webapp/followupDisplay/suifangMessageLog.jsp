<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${page.total!=0}">
    <div class="table-responsive">
        <table id="initTable" class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <th>随访人</th>
                <th>发送状态</th>
                <th>发送内容</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="pageobj">
                <tr id="${pageobj.uid}">
                    <td>
                            ${pageobj.managername}
                    </td>
                    <td>
                        <c:if test="${pageobj.sendrscode==301}">成功</c:if>
                        <c:if test="${pageobj.sendrscode!=301}">
                            ${pageobj.sendrsmessage}
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${fn:length(pageobj.messagecontent)>10}">${ fn:substring(pageobj.messagecontent ,0,10)} ...</c:if>
                        <c:if test="${fn:length(pageobj.messagecontent)<=10}">${pageobj.messagecontent}</c:if>
                    </td>
                    <td><a class="label label-success" ajaxLayerWindow href="/followupDisplay/beizhu.jsp?beizhu=${pageobj.messagecontent}" title="查看短信" width="500" height="350">查看短信</a></td>
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
    <input id="loadDataURL" type="hidden" value="/sdeyfollowup/suifangEnterMessage"/>
    <input id="searFormID" type="hidden" value="subForm"/>
    <!--
    分页结束
    -->
    <div class="clearfix"></div>
</c:if>
<div class="form-group" style="margin-top: 30px;">
    <button type="button" class="btn btn-default" id="backPageID" searFormID="subForm"
            href="/sdeyfollowup/getOutHosMembers">
        返回
    </button>
</div>
<form id="subForm" method="post">
<c:forEach items="${paramValues}" var="item">
    <input name="${item.key}" value="${item.value[0]}" type="hidden"/>
</c:forEach>
</form>
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/followupDisplay/suifang.js"></script>