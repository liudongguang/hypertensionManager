<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    .scbtn {
        font: 15px Tahoma, Verdana;
        color: #000000;
        cursor: pointer;
    }
</style>
<div class="row">
    <div class="col-md-12">
        <form id="subForm" action="webPatientHandler/savePatient" method="post"
              class="form-horizontal">
            <input type="hidden" name="uid" value="${obj.uid}"/>
            <input type="hidden" name="imgpici"
                   value="<c:if test="${obj!=null}">${obj.imgpici}</c:if><c:if test="${obj==null}">${pici}</c:if> "/>

            <div class="form-group">
                <label class="col-md-3 control-label">患者姓名：</label>
                <div class="col-md-4">
                    <input type="text" name="name" required errInfo="患者姓名不能为空！" value="${obj.name}"
                           class="form-control" placeholder="请输入患者姓名.....">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">手机号：</label>
                <div class="col-md-4">
                    <input type="text" name="registphone" required errInfo="手机号不能为空！" value="${obj.registphone}"
                           class="form-control" placeholder="请输入手机号.....">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">性别：</label>
                <div class="col-md-4">
                    <label class="radio-inline">
                        <input type="radio" name="sex" value="1"
                               <c:if test="${obj!=null&&obj.sex==1}">checked="checked"</c:if>
                        > 男
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="sex" value="2"
                               <c:if test="${obj!=null&&obj.sex==2}">checked="checked"</c:if>
                        > 女
                    </label>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">出生日期：</label>
                <div class="col-md-4">
                    <input type="text" name="birthday"  value="${obj.birthday}"
                           class="form-control" placeholder="请输入出生日期.....">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">设备分配：</label>
                <div class="col-md-4">
                    <input type="text" name="shebeiName" readonly="readonly" value="${obj.shebeiName}"
                           class="form-control scbtn" placeholder="点击设备分配">
                    <input type="hidden" name="shebeiUID" readonly="readonly" value="${obj.shebeiUID}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">租借时间：</label>
                <div class="col-md-4">
                        <input type="text" name="zjstart" value="${obj.zjstart}" placeholder="租借开始时间"  class="form-control radio-inline" style="width: 200px;"
                               />
                         -
                        <input type="text" name="zjend" value="${obj.zjend}" placeholder="租借结束时间" class="form-control radio-inline" style="width: 200px;"
                              />
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">备注：</label>
                <div class="col-md-4">
                    <textarea rows="5" cols="15" name="beizhu" class="form-control">${obj.beizhu}</textarea>
                    <button id="subBT" type="button" class="btn btn-default pull-right"
                            style="margin-top: 10px;">提交
                    </button>

                </div>
            </div>
        </form>
    </div>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jsppage/patient/add.js"></script>

