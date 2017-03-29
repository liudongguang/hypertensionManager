<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="clearfix"></div>
<div class="col-md-6">
    <form class="form-horizontal" id="subForm" method="post" action="sdeyfollowup/saveMsgModel">
        <div class="form-group">
            <label class="col-md-2 control-label">标题</label>
            <div class="col-md-8">
                <input class="form-control" name="title" required errInfo="标题不能为空" type="text" placeholder="标题">
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">内容</label>
            <div class="col-md-8">
                <textarea name="msgcontent" maxlength="70" cols="70" rows="5" required errInfo="短信内容不能为空" placeholder="最多70个字！"></textarea>
            </div>
        </div>
    </form>
    <div class="form-group col-md-offset-4" style="margin-top: 30px">
        <button class="btn btn-primary" id="subBT" type="button">保存</button>
        <button id="backBTID" href="/sdeyfollowup/getManagerList" class="btn btn-default" type="button">返回</button>
    </div>
</div>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>

<script language="javascript" type="text/javascript" src="assets/js/followupManager/msgmodel/addmsgmodel.js"></script>

