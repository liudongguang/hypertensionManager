<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${page.total!=0}">
    <div class="table-responsive">
        <table id="initTable" class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <th>随访人</th>
                <th>随访状态</th>
                <th>恢复情况</th>
                <th>是否满意</th>
                <th>随访日期</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="pageobj">
                <tr id="${pageobj.uid}">
                    <td>
                            ${pageobj.workername}
                    </td>
                    <td>
                        <c:if test="${pageobj.followupstate==null}">未随访</c:if>
                        <c:if test="${pageobj.followupstate==2}"><span style="color: green;">已随访</span></c:if>
                        <c:if test="${pageobj.followupstate==3}"><span style="color: red;">联系不上</span></c:if>
                    </td>
                    <td>
                        <c:if test="${pageobj.huifustate==1}">是</c:if>
                        <c:if test="${pageobj.huifustate==2}">否</c:if>
                    </td>
                    <td>
                        <c:if test="${pageobj.manyistate==1}">满意</c:if>
                        <c:if test="${pageobj.manyistate==2}">不满意</c:if>
                    </td>
                    <td><fmt:formatDate value="${pageobj.logdate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td>
                        <c:if test="${fn:length(pageobj.beizhu)>10}">${ fn:substring(pageobj.beizhu ,0,10)} ...</c:if>
                        <c:if test="${fn:length(pageobj.beizhu)<=10}">${pageobj.beizhu}</c:if>
                    </td>
                    <td><a class="label label-success" ajaxLayerWindow href="/followupDisplay/beizhu.jsp?beizhu=${pageobj.beizhu}" title="查看备注" width="500" height="350">查看备注</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--
    分页开始
    -->
    <div id="pagesDIV" style="margin: 0 auto"></div>
    <input id="pageNum" type="hidden" value="${page.pageNum}"/>
    <input id="pageSize" type="hidden" value="${page.pageSize}"/>
    <input id="total" type="hidden" value="${page.total}"/>
    <input id="loadDataURL" type="hidden" value="/sdeyfollowup/getSuifangLogPage"/>
    <input id="searFormID" type="hidden" value="subForm"/>
    <!--
    分页结束
    -->
    <div class="clearfix"></div>
</c:if>
<form id="subForm" method="post" action="sdeyfollowup/saveSuiFangLog">
    <input type="hidden" id="manageridID" name="workerid" value="${sessionScope.user.uid}"/>
    <input type="hidden" name="workername" value="${sessionScope.user.name}"/>
    <input type="hidden" name="pationtid" value="${obj.uid}"/>
    <div class="table-responsive">
        <table class="table table-striped table-hover table-bordered">
            <tbody>
            <tr>
                <td><span class="txt_td">随访日期</span></td>
                <td class="input-group"><input required errInfo="访问日期不能为空！" id="logdateID" name="logdate" class="form-control" type="text">
                </td>
                <td><span class="txt_td">随访人</span></td>
                <td><input type="text" class="form-control" value="${sessionScope.user.name}" readonly></td>
                <td><span class="txt_td">病人姓名</span></td>
                <td><input type="text" class="form-control" value="${obj.brxm}${param.brxm}" name="brxm" readonly></td>
                <td><span class="txt_td">年龄</span></td>
                <td><input type="text" class="form-control" value="${obj.age}${param.age}" name="age" readonly></td>
                <td><span class="txt_td">联系方式</span></td>
                <td><input type="text" class="form-control" value="${obj.lxdh}${param.lxdh}" name="lxdh" readonly></td>

            </tr>
            <tr>
                <td><span class="txt_td">家庭电话</span></td>
                <td><input class="form-control" type="text" value="${obj.jtdh}${param.jtdh}" name="jtdh" readonly></td>
                <td><span class="txt_td">出院诊断</span></td>
                <td><input type="text" class="form-control" value="${obj.zd}${param.zd}" name="zd" readonly></td>
                <td><span class="txt_td">随访状态</span></td>
                <td>
                    <input id="hiddenval_followupstate" type="hidden" value="${param.followupstate}"/>
                    <label class="radio-inline">
                        <input type="radio" name="followupstate" value="2" checked="">
                        电话随访 </label>
                    <label class="radio-inline">
                        <input type="radio" name="followupstate" value="3">
                        联系不上 </label></td>
                <td><span class="txt_td">是否康复</span></td>
                <td>
                    <input id="hiddenval_huifustate" type="hidden" value="${param.huifustate}"/>
                    <label class="radio-inline">
                        <input type="radio" name="huifustate" value="1" checked="">
                        是 </label>
                    <label class="radio-inline">
                        <input type="radio" name="huifustate" value="2">
                        否 </label></td>
                <td><span class="txt_td">是否满意</span></td>
                <td>
                    <input id="hiddenval_manyistate" type="hidden" value="${param.manyistate}"/>
                    <label class="radio-inline">
                        <input type="radio" name="manyistate" value="1" checked="">
                        满意 </label>
                    <label class="radio-inline">
                        <input type="radio" name="manyistate" value="2">
                        不满意 </label></td>
            </tr>
            <tr>
                <td><span class="txt_td">备注</span></td>
                <td colspan="3"><textarea required name="beizhu" errInfo="备注不能为空！" class="form-control" rows="3"
                                          maxlength="500" placeholder="最多输入500字">${param.beizhu}</textarea></td>
                <td colspan="6"></td>
            </tr>
            </tbody>
        </table>
    </div>
    <c:forEach items="${paramValues}" var="item">
        <input name="${item.key}" value="${item.value[0]}" type="hidden"/>
    </c:forEach>
</form>
<div class="form-group" style="margin-top: 30px;">
    <button id="subBT" type="button" class="btn btn-primary   col-lg-offset-5">保存</button>
    <button type="button" class="btn btn-default" id="backPageID" searFormID="subForm"
            href="/sdeyfollowup/getOutHosMembers">
        返回
    </button>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/followupDisplay/suifang.js"></script>