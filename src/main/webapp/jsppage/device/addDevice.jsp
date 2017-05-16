<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <div class="col-md-12">
        <form id="subForm${param.setNum}" action="deviceHandler/saveDevice" method="post"
              class="form-horizontal">
            <input type="hidden" name="uid" value="${obj.uid}"/>
            <div class="form-group">
                <label class="col-md-3 control-label">SN：</label>
                <div class="col-md-4">
                    <input type="text" name="sn" required errInfo="SN不能为空！" value="${obj.sn}"
                           class="form-control" placeholder="请输入SN.....">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">IMEI：</label>
                <div class="col-md-4">
                    <input type="text" name="imei" required errInfo="IMEI不能为空！" value="${obj.imei}"
                           class="form-control" placeholder="请输入IMEI.....">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">名称：</label>
                <div class="col-md-4">
                    <input type="text" name="alias" required errInfo="名称不能为空！" value="${obj.alias}"
                           class="form-control" placeholder="请输入名称.....">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">激活状态：</label>
                <div class="col-md-4">
                    <label class="radio-inline">
                        <input type="radio" name="enable" value="1" checked="checked"> 是
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="enable" value="2" > 否
                    </label>
                    <input type="hidden" id="radio_enable" value="${obj.enable}"/>
                    <button id="subBT" type="button" class="btn btn-default pull-right"
                            style="margin-top: 10px;">提交
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jsppage/device/addDevice.js"></script>

