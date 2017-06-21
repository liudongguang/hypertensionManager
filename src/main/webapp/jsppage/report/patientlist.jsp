<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
    <div style="margin-bottom: 10px;">
        <form class="form-inline" id="subForm" action="webPatientHandler/patientListForReport">
            <div class="form-group">
                <label for="snid">姓名</label>
                <input type="text" name="name" class="form-control" id="snid" placeholder="查询的病人姓名" value="${param.name}">
            </div>
            <div class="form-group" style="margin-left: 15px;">
                <label for="nameid">手机号</label>
                <input type="text" name="registphone" class="form-control" id="nameid" placeholder="查询的手机号" value="${param.registphone}">
            </div>
        </form>
        <div class="pull-right"><button id="subBT" type="button" class="btn btn-default">查询</button></div>
    </div>

    <button class="btn btn-primary ldgbtmarginbottom5" id="addPatient" type="button">新增</button>

    <div class="table-responsive">
        <table class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <th>姓名</th>
                <th>手机</th>
                <th>性别</th>
                <th>年龄</th>
                <th>SN</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="obj">
                <tr>
                    <td>${obj.name}</td>
                    <td>${obj.registphone}</td>
                    <td>
                            ${obj.sex}
                    </td>
                    <td>
                            ${obj.age}
                    </td>
                    <td>
                        <c:if test="${obj.sn!=null}">
                            ${obj.sn}
                        </c:if>
                        <c:if test="${obj.sn==null||fn:length(fn:trim(obj.sn))==0}">
                            <span style="color: red">未绑定</span>
                        </c:if>
                    </td>
                    <td>
                        <a class="label label-warning" target="view_window" title="【${obj.name}】报告" width="100%" height="100%"
                           href="webPatientHandler/getReport?patientuid=${obj.uid}&name=${obj.name}&sex=${obj.sex}">报告</a>
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
    <input id="loadDataURL" type="hidden" value="/webPatientHandler/patientListForReport"/>
    <input id="searFormID" type="hidden" value="subForm"/>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jsppage/patient/list.js"></script>