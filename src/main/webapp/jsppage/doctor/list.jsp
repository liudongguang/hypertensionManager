<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
    <div style="margin-bottom: 10px;">
        <form class="form-inline" id="subForm" action="webDoctorHandler/doctorList">
            <div class="form-group">
                <label for="snid">医生姓名</label>
                <input type="text" name="name" class="form-control" id="snid" placeholder="查询的医生姓名" value="${param.name}">
            </div>
            <div class="form-group" style="margin-left: 15px;">
                <label for="nameid">工号</label>
                <input type="text" name="gonghao" class="form-control" id="nameid" placeholder="查询的工号" value="${param.gonghao}">
            </div>
        </form>
        <div class="pull-right"><button id="subBT" type="button" class="btn btn-default">查询</button></div>
    </div>
    <button class="btn btn-primary ldgbtmarginbottom5" id="addDoctor" type="button" pici="${pici}">新增</button>
    <div class="table-responsive">
        <table class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <th>医生姓名</th>
                <th>工号</th>
                <th>所在科室</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="obj">
                <tr>
                    <td>${obj.name}</td>
                    <td>${obj.gonghao}</td>
                    <td>${obj.keshi}</td>
                    <td>
                        <a class="label label-info" ajaxthispage
                           href="/webDoctorHandler/editDoctor?uid=${obj.uid}">编辑</a>
                        <a class="label label-warning" ajaxdel
                           href="/webDoctorHandler/delDoctorById?uid=${obj.uid}&imgpici=${obj.imgpici}">删除</a>
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
    <input id="loadDataURL" type="hidden" value="/webDoctorHandler/doctorList"/>
    <input id="searFormID" type="hidden" value="subForm"/>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jsppage/doctor/list.js"></script>