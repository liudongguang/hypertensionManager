<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link type="text/css" rel="stylesheet" href="assets/summernote/summernote.css">
<div >
    <form class="form-horizontal" action="webHandler/saveDisclaimer" novalidate id="subForm" method="post">
        <input type="hidden" name="uid" value="${obj.uid}"/>
        <input type="hidden" name="pici" value="${obj.pici}" id="piciID">
        <textarea  maxlength="4000" required errInfo="内容不能为空" name="content" class="summernote" id="contents" title="Contents">${obj.content}</textarea>
        <button id="subBT" type="submit" class="btn btn-default">保存</button>
    </form>
</div>
<script language="javascript" type="text/javascript" src="assets/summernote/summernote.js"></script>
<script language="javascript" type="text/javascript" src="assets/summernote/lang/summernote-zh-CN.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/zixun/disclaimer/add.js"></script>