<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link type="text/css" rel="stylesheet" href="assets/summernote/summernote.css">
<div class="row">
    <div class="col-md-12">
        <form id="subForm${param.setNum}" action="webDoctorHandler/saveDoctorInfo" method="post"
              class="form-horizontal">
            <input type="hidden" name="uid" value="${obj.uid}"/>
            <input type="hidden" name="imgpici"
                   value="<c:if test="${obj!=null}">${obj.imgpici}</c:if><c:if test="${obj==null}">${pici}</c:if> "/>
            <div class="form-group">
                <label class="col-md-3 control-label">医生头像：</label>
                <div class="col-md-9">
                    <img id="checkfmID" style="width: 200px;height: 200px;cursor:pointer;"
                         src="<c:if test="${obj==null}">assets/images/rongyunHead.png</c:if><c:if test="${obj!=null}">${obj.headimg}</c:if>"/>
                    <input type="hidden" name="headimg" value="${obj.headimg}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">医生姓名：</label>
                <div class="col-md-4">
                    <input type="text" name="name" required errInfo="医生姓名不能为空！" value="${obj.name}"
                           class="form-control" placeholder="请输入医生姓名.....">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">医生工号：</label>
                <div class="col-md-4">
                    <input type="text" name="gonghao" required errInfo="医生工号不能为空！" value="${obj.gonghao}"
                           class="form-control" placeholder="请输入医生工号.....">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">职称：</label>
                <div class="col-md-4">
                    <input type="text" name="zhicheng" required errInfo="职称不能为空！" value="${obj.zhicheng}"
                           class="form-control" placeholder="请输入职称.....">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">工作单位：</label>
                <div class="col-md-4">
                    <input type="text" name="workdanwei" required errInfo="工作单位不能为空！" value="${obj.workdanwei}"
                           class="form-control" placeholder="请输入工作单位.....">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">手机号：</label>
                <div class="col-md-4">
                    <input type="text" name="mobile" required errInfo="手机号不能为空！" value="${obj.mobile}"
                           class="form-control" placeholder="请输手机号.....">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">所在科室：</label>
                <div class="col-md-4">
                    <input type="text" name="keshi" required errInfo="所在科室不能为空！" value="${obj.keshi}"
                           class="form-control" placeholder="请输入所在科室.....">
                    <c:if test="${obj!=null}">
                        <button id="subBT" type="button" class="btn btn-default pull-right"
                                style="margin-top: 10px;">提交
                        </button>
                    </c:if>
                </div>
            </div>
            <c:if test="${obj==null}">
                <div class="form-group">
                    <label class="col-md-3 control-label">登录帐号：</label>
                    <div class="col-md-4">
                        <input type="text" name="username" required errInfo="登录帐号不能为空！" value="${obj.username}"
                               class="form-control" placeholder="请输入登陆帐号.....">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">登录密码：</label>
                    <div class="col-md-4">
                        <input type="password" name="password" value="${obj.password}"
                               class="form-control" placeholder="请输入登陆密码.....(不输入则密码为工号)">
                        <button id="subBT" type="button" class="btn btn-default pull-right"
                                style="margin-top: 10px;">提交
                        </button>
                    </div>
                </div>
            </c:if>
        </form>
    </div>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jsppage/doctor/add.js"></script>

