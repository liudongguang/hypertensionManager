<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="clearfix"></div>
<div class="col-md-6">
<form class="form-horizontal" id="subForm" method="post" action="sdeyfollowup/saveManager">
    <div class="form-group">
        <label class="col-md-2 control-label">姓名</label>
        <div class="col-md-8">
            <input class="form-control" name="name" required errInfo="姓名不能为空" type="text" placeholder="姓名">
        </div>
    </div>

        <div class="form-group">
            <label class="col-md-2 control-label">用户名</label>
            <div class="col-md-8">
                <input name="username" type="text" required errInfo="用户名不能为空" class="form-control"  placeholder="用户名">
            </div>
        </div>
    <div class="form-group">
        <label class="col-md-2 control-label">密码</label>
        <div class="col-md-8">
            <input class="form-control" name="pass" required errInfo="密码不能为空" type="password" placeholder="密码">
        </div>
    </div>
</form>
<div class="form-group col-md-offset-4" style="margin-top: 30px">
    <button class="btn btn-primary" id="subBT" type="button">保存</button>
    <button id="backBTID" href="/sdeyfollowup/getManagerList" class="btn btn-default" type="button">返回</button>
</div>
</div>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/followupManager/manager/addManager.js"></script>

