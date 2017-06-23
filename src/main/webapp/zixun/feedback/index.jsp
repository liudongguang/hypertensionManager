<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
    <div style="margin-bottom: 10px;">
        <form class="form-inline" id="subForm" action="webHandler/feedback_list">
            <div class="form-group">
                <label for="snid">手机号</label>
                <input type="text" name="userregistphone" class="form-control" id="snid" placeholder="查询的手机号"
                       value="${param.userregistphone}"/>
            </div>
            <div class="form-group" style="margin-left: 15px;position: relative;">
                <label for="startTimeID">查询时间</label>
                <input type="text" name="start" class="form-control" id="startTimeID" value="${param.start}"/> - <input
                    type="text" name="end" class="form-control" id="endTimeID" value="${param.end}"/>
            </div>
        </form>
        <div class="pull-right">
            <button id="subBT" type="button" class="btn btn-default">查询</button>
        </div>
    </div>
    <button class="btn btn-primary ldgbtmarginbottom5" id="addfeedbackID" type="button" pici="${pici}">新增</button>
    <div class="table-responsive">
        <table class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <th>注册手机号</th>
                <th>内容</th>
                <th>图片</th>
                <th>联系方式</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="obj">
                <tr>
                    <td style="vertical-align:middle">${obj.userregistphone}</td>
                    <td style="vertical-align:middle">
                        <c:choose>
                            <c:when test="${fn:length(obj.content) > 10}">
                                <c:out value="${fn:substring(obj.content, 0, 10)}......"/>
                            </c:when>
                            <c:otherwise>
                                <c:out value="${obj.content}"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td style="vertical-align:middle">
                        <c:forEach items="${obj.contentimgsList}" var="img">
                            <img src="${img}" style="width: 70px;height: 70px;border-radius:5px;"/>
                        </c:forEach>
                    </td>
                    <td style="vertical-align:middle">${obj.lxfs}</td>
                    <td style="vertical-align:middle"><fmt:formatDate value="${obj.createtime}"
                                                                      pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td style="vertical-align:middle">
                        <a class="label label-warning" ajaxdel
                           href="/webHandler/delFeedBackById?uid=${obj.uid}&pici=${obj.pici}">删除</a>
                        <a class="label label-success" ajaxLayerWindowFrame title="意见反馈" width="500" height="600"
                           href="/webHandler/displayFeedBackById?uid=${obj.uid}">查看</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--分页开始-->
    <div id="pagesDIV" style="margin: 0 auto"></div>
    <input id="pageNum" type="hidden" value="${page.pageNum}"/>
    <input id="pageSize" type="hidden" value="${page.pageSize}"/>
    <input id="pages" type="hidden" value="${page.pages}"/>
    <input id="total" type="hidden" value="${page.total}"/>
    <input id="loadDataURL" type="hidden" value="/webHandler/feedback_list"/>
    <input id="searFormID" type="hidden" value="subForm"/>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/zixun/feedback/index.js"></script>