<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row margin-bottom-30">
    <div class="col-md-12">
        <form id="subForm" action="sdeyfollowup/getOutHosMembers" class="form-inline" method="post">
            <div class="form-group">
                <label class="radio-inline">
                    <input id="hiddenval_state" type="hidden" value="${param.state}"/>
                    <input type="radio" name="state" value="1">
                    未随访 </label>
                <label class="radio-inline">
                    <input type="radio" name="state" value="2">
                    已随访 </label>
            </div>
            <div class="form-group" style="margin-left:15px;">
                <span>病人姓名：</span>
                <input name="patientName" class="form-control" type="text"   value="${param.patientName}">
            </div>
            <div class="form-group" style="margin-left:15px;">
                <span>请选择日期：</span>
                <input name="startTime" class="form-control" type="text" id="startTimeID"
                       value="${param.startTime}">
                —
                <input name="endTime" class="form-control" type="text" id="endTimeID"
                       value="${param.endTime}">
            </div>
            <input id="hiddenval_ksid" type="hidden" value="${param.ksid}"/>
            <select name="ksid" class="form-control" id="singleSelect">
                <option value="">请选择科室</option>
                 <c:forEach items="${kslist}" var="ks">
                     <option value="${ks}">${ks}</option>
                 </c:forEach>
            </select>
            <button id="subBT" type="button" class="btn btn-primary">查询</button>
        </form>

    </div>
</div>
<div class="row margin-bottom-30">
    <div class="col-md-12">
        <form class="form-inline">
            <!--
            <a class="label label-primary" href="查看.html"><span class="glyphicon glyphicon-pencil"
                                                                style="margin-right:3px;"></span>查看</a>
            <a class="label label-info" href="患者随访.html"><span class="glyphicon glyphicon-pencil"
                                                               style="margin-right:3px;"></span>患者随访</a>
            <a class="label label-warning" href="提取备注.html"> <span class="glyphicon glyphicon-list-alt"
                                                                   style="margin-right:3px;"></span>提取备注</a>
                                                                   -->
            <%--<a class="label label-warning" href="住院记录.html"> <span class="glyphicon glyphicon-list-alt"
                                                                   style="margin-right:3px;"></span>住院记录</a>--%>
        </form>
        <button id="sendMsgID" searFormID="subForm" pageNum="${page.pageNum}">
            <span  class="glyphicon glyphicon-list-alt" style="margin-right:3px;" ></span>短信发送
        </button>
    </div>
</div>
<div class="table-responsive">
    <table class="table table-striped table-hover table-bordered">
        <thead>
        <tr>
            <th><input type="checkbox" id="checkAllCheckBox"> </th>
            <th>住院号码</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>出院科室</th>
            <th>出院时间</th>
            <th>主要诊断</th>
            <th>治愈情况</th>
            <th>联系电话</th>
            <th>家庭电话</th>
            <th>随访状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="obj">
            <tr id="${obj.uid}">
                <td>
                    <input type="checkbox" name="uids_${obj.uid}" managerid="${obj.managerid}" workid="${obj.workid}" value="${obj.uid}"/>
                </td>
                <td>${obj.zyhm}</td>
                <td>${obj.brxm}</td>
                <td>${obj.xb}</td>
                <td>${obj.age}</td>
                <td>${obj.cyks}</td>
                <td><fmt:formatDate value="${obj.cyrq}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td>${obj.zd}</td>
                <td>${obj.zgqk}</td>
                <td id="tdlxdh_${obj.uid}">${obj.lxdh}</td>
                <td id="tdjtdh_${obj.uid}">${obj.jtdh}</td>
                <td>
                    <c:if test="${obj.workstate==null}">未随访</c:if>
                    <c:if test="${obj.workstate==1}"><span style="color: green;">已随访</span></c:if>
                </td>
                <td>
                    <!--
                    <a class="label label-warning" href="住院记录.html"> <span class="glyphicon glyphicon-list-alt"
                                                                           style="margin-right:3px;"></span>住院记录</a>
                                                                           -->
                    <a class="label label-warning" ajaxthispage searFormID="subForm" pageNumParam="${page.pageNum}"   titleParam="${param.titleParam}"
                       href="/sdeyfollowup/suifangEnterMessage?uid=${obj.uid}">短信随访</a>
                    <a class="label label-success" ajaxthispage searFormID="subForm" pageNumParam="${page.pageNum}" titleParam="${param.titleParam}"
                       href="/sdeyfollowup/suifangEnter?uid=${obj.uid}&workid=${obj.workid}&managerid=${obj.managerid}">电话随访</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<input type="hidden" id="manageridID" value="${sessionScope.user.uid}"/>
<!--
分页开始
-->
<div id="pagesDIV" style="margin: 0 auto"></div>
<input id="pageNum" type="hidden" value="${page.pageNum}"/>
<input id="pageSize" type="hidden" value="${page.pageSize}"/>
<input id="pages" type="hidden" value="${page.pages}"/>
<input id="total" type="hidden" value="${page.total}"/>
<input id="loadDataURL" type="hidden" value="/sdeyfollowup/getOutHosMembers"/>
<input id="searFormID" type="hidden" value="subForm"/>
<!--
分页结束
-->
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/followupDisplay/disMembers.js"></script>
