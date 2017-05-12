<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link type="text/css" rel="stylesheet" href="assets/summernote/summernote.css">
<div class="row">
    <div class="col-md-3" style="margin-top: 150px;"><img id="checkfmID${param.setNum}" style="width: 320px;height: 180px;padding-left: 50px;"
                               src="<c:if test="${obj.homeimage==null}">assets/images/rongyunHead.png</c:if><c:if test="${obj.homeimage!=null}">${obj.homeimage}</c:if>">
    </div>
    <div class="col-md-9">
        <form id="subForm${param.setNum}" action="webHandler/saveLunboImgContent" method="post" class="form-horizontal">
            <!--图片地址-->
            <input type="hidden" id="checkfmID${param.setNum}_path" name="homeimage"/>
            <input type="hidden" name="uid" value="${obj.uid}"/>
            <input type="hidden" name="pici" value="${obj.pici}"/>
            <input type="hidden" name="setNum" value="${param.setNum}" />
            <div class="form-group">
                <label class="col-md-2 control-label">是否使用外部连接：</label>
                <div class="col-md-10">
                    <label class="radio-inline">
                        <input type="radio" name="linkState" value="1"> 是
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="linkState" value="2" checked="checked"> 否
                    </label>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">连接地址：</label>
                <div class="col-md-10">
                    <input type="text" name="homeimageurl" value="${obj.homeimageurl}" class="form-control" disabled="disabled" placeholder="请输入连接地址....." >
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">内容介绍：</label>
                <div class="col-md-10">
                    <textarea name="content" class="summernote" id="contents${param.setNum}" title="Contents">${obj.content}</textarea>
                </div>
                <button id="subBT${param.setNum}" type="button" class="btn btn-default pull-right" style="margin-right: 13px;">提交</button>
            </div>
        </form>
    </div>
</div>
<script language="javascript" type="text/javascript" src="assets/summernote/summernote.js"></script>
<script language="javascript" type="text/javascript" src="assets/summernote/lang/summernote-zh-CN.js"></script>
<script src="assets/js/zixun/lunbo/setContent.js" type="text/javascript"></script>

