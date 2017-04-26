<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="assets/bootstrap-fileinput/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
<link href="assets/bootstrap-fileinput/themes/explorer/theme.css" media="all" rel="stylesheet" type="text/css"/>
<div style="width: 80%">
    <form class="form-horizontal" id="subForm" method="post">
        <div class="form-group">
            <label class="col-md-2 control-label"> 连接地址1：</label>
            <div class="col-md-8">
                <input class="form-control" type="text" name="file1_homeimage"/>
            </div>
        </div>
        <input id="file1"  name="file1" type="file">
        <div class="form-group">
            <label class="col-md-2 control-label"> 连接地址2：</label>
            <div class="col-md-8">
                <input class="form-control" type="text" name="file2_homeimage"/>
            </div>
        </div>
        <input id="file2" name="file2" type="file">
        <div class="form-group">
            <label class="col-md-2 control-label"> 连接地址3：</label>
            <div class="col-md-8">
                <input class="form-control" type="text" name="file3_homeimage"/>
            </div>
        </div>
        <input id="file3" name="file3" type="file">
    </form>
</div>
<script src="assets/bootstrap-fileinput/js/plugins/sortable.js" type="text/javascript"></script>
<script src="assets/bootstrap-fileinput/js/fileinput.js" type="text/javascript"></script>
<script src="assets/bootstrap-fileinput/js/locales/zh.js" type="text/javascript"></script>
<script src="assets/bootstrap-fileinput/themes/explorer/theme.js" type="text/javascript"></script>
<script src="assets/js/hypertensionMain/lunboupload.js" type="text/javascript"></script>