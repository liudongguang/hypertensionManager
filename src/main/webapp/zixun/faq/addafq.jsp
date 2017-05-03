<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link type="text/css" rel="stylesheet" href="assets/summernote/summernote.css">
<div>
    <form action="webHandler/save_faq" novalidate id="subForm" method="post">
      <textarea name="content" class="summernote" id="contents" title="Contents"></textarea>
      <button id="subBT" type="submit" class="btn btn-default">submit</button>
    </form>
</div>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/summernote/summernote.js"></script>
<script language="javascript" type="text/javascript" src="assets/summernote/lang/summernote-zh-CN.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/zixun/faq/addafq.js"></script>