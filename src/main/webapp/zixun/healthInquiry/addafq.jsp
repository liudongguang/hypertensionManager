<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link type="text/css" rel="stylesheet" href="assets/summernote/summernote.css">
<div >
    <form class="form-horizontal" action="webHandler/save_faq" novalidate id="subForm" method="post">
        <input type="hidden" name="uid" value="${obj.uid}"/>
        <div class="form-group">
            <label class="col-md-2 control-label">标题：</label>
            <div class="col-md-8">
                <input type="text" name="title" class="form-control" required errInfo="标题名不能为空" value="${obj.title}"></div>
        </div>
        <input type="hidden" name="pici" value="${param.pici}" id="piciID">
        <textarea required errInfo="内容不能为空" name="content" class="summernote" id="contents" title="Contents">${obj.content}</textarea>
        <button id="subBT" type="submit" class="btn btn-default">保存</button>
    </form>
</div>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/summernote/summernote.js"></script>
<script language="javascript" type="text/javascript" src="assets/summernote/lang/summernote-zh-CN.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/zixun/healthInquiry/add.js"></script>