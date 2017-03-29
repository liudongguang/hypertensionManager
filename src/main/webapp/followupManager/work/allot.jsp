<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="clearfix"></div>
<style>
    .user_list {
        /*background: #f1f3f6;*/
        padding-top: 10px;
        max-height: 490px;
        overflow: auto;
    }

    .user_list li {
        float: left;
        list-style: none;
        padding: 2px;
    }

    .user_header {
        background: #eee;
        padding: 10px 15px;
        width: 100%;
        margin-top: 0;
        color: #0099b9
    }
</style>
<div class="row">
    <form action="sdeyfollowup/fenpeiWork" class="form-inline" id="subForm">
        <div class=" pull-right" style="padding-right: 30px;">
            <div class="form-group">
                <label>可分配日期:</label>
                <select class="form-control" name="fenpeiDate" id="fenpeiDateID">
                    <option value="">-----
                        <c:if test="${fn:length(keFenPeiList)==0}">无可分配日期</c:if>
                        <c:if test="${fn:length(keFenPeiList)>0}">请选择</c:if>
                        -----
                    </option>
                    <c:forEach items="${keFenPeiList}" var="obj">
                        <option value="${obj.importDateStr}"> ${obj.importDateStr}[${obj.count}条]</option>
                    </c:forEach>
                </select>
            </div>
            <button id="fenpeiID" type="button" class="btn btn-primary">分配</button>
        </div>

        <div class="clearfix"></div>
        <hr>
        <div class="col-lg-4">
            <h4 class="user_header">员工列表</h4>
            <div style="height: 500px; border:1px solid #bbbbbb;">
                <ul class="user_list">
                    <c:forEach items="${page.list}" var="obj">
                        <c:if test="${obj.username!='admin'}">
                            <li class="col-lg-4">
                                <div class="checkbox">
                                    <label>
                                        <input name="userid" type="checkbox" value="${obj.uid}"> ${obj.name}
                                    </label>
                                </div>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </form>
    <div class="col-lg-8">
        <c:if test="${fn:length(managerWork) > 0}">
            <div class="table-responsive">
                <div class="table-responsive">
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>姓名</th>
                            <th>用户名</th>
                            <th>个数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${managerWork}" var="obj">
                            <tr id="${obj.uid}">
                                <td>${obj.name}</td>
                                <td>${obj.username}</td>
                                <td>${obj.workcount}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </c:if>
    </div>
</div>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/followupManager/work/allot.js"></script>


