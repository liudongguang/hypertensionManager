<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
    <button class="btn btn-primary ldgbtmarginbottom5" id="addDevice" type="button">新增</button>
    <div class="table-responsive">
        <table class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <th>sn</th>
                <th>imei</th>
                <th>名称</th>
                <th>激活状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="obj">
                <tr>
                    <td>${obj.sn}</td>
                    <td>${obj.imei}</td>
                    <td>${obj.alias}</td>
                    <td>
                        <c:if test="${obj.enable==1}">是</c:if>
                        <c:if test="${obj.enable==2}">否</c:if>
                    </td>
                    <td>
                        <a class="label label-info" ajaxthispage
                           href="/deviceHandler/editDevice?uid=${obj.uid}">编辑</a>
                        <a class="label label-warning" ajaxdel
                           href="/deviceHandler/delDeviceById?uid=${obj.uid}">删除</a>
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
    <input id="loadDataURL" type="hidden" value="/deviceHandler/deviceList"/>
    <input id="searFormID" type="hidden" value="subForm"/>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jsppage/device/devicelist.js"></script>