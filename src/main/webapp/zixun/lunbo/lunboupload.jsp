<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!--tabs-left:选项卡在左边显示 -->
<input type="hidden" name="pici" value="${param.pici}" id="piciID">
<div class="tabbable">
    <!--nav-pills，nav-tabs，nav-stacked :改变选项卡的样式-->
    <ul class="nav nav-tabs">
        <li class="active"><a href="#tab1" data-toggle="tab">第一张</a>
        </li>
        <li><a href="#tab2" data-toggle="tab">第二张</a>
        </li>
        <li><a href="#tab3" data-toggle="tab">第三张</a>
        </li>
    </ul>
    <!-- 选项卡相对应的内容 -->
    <div class="tab-content">
        <div class="tab-pane active" id="tab1">

        </div>
        <div class="tab-pane" id="tab2">

        </div>
        <div class="tab-pane" id="tab3">

        </div>
    </div>
</div>
<script src="assets/js/zixun/lunbo/lunboupload.js" type="text/javascript"></script>