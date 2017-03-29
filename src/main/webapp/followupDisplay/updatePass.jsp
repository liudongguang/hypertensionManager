<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="subFormUpdatePass" class="form-horizontal" method="post" action="sdeyfollowup/updatePass">
    <input name="managerid" type="hidden" value="${sessionScope.user.uid}"/>
    <input type="hidden" id="jumpPageLayerNumKeepAliveID" value="1"/>
    <div class="form-group">
        <label class="col-lg-2 control-label">原密码</label>
        <div class="col-lg-10">
            <input type="password" required  name="oldpassword"  class="form-control" placeholder="原密码" errInfo="原密码不能为空！">
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-2 control-label">新密码</label>
        <div class="col-lg-10">
            <input type="password" required name="newpassword" id="newpasswordID" class="form-control" placeholder="新密码" errInfo="新密码不能为空！">
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-2 control-label">重复密码</label>
        <div class="col-lg-10">
            <input type="password" required name="newpassword2" id="newpassword2ID" class="form-control" placeholder="重复密码" errInfo="重复密码不能为空！">
        </div>
    </div>
</form>
<div class="form-group" style="margin-top: 30px;">
    <button id="subUpdatePassBT" type="button" class="btn btn-primary   col-lg-offset-5">保存</button>
    <button type="button" class="btn btn-default" id="backPageID">
        返回
    </button>
</div>

<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/followupDisplay/updatePass.js"></script>