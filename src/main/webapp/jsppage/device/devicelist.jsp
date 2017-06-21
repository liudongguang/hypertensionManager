<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
    <div style="margin-bottom: 10px;">
        <form class="form-inline" id="subForm" action="deviceHandler/deviceList">
            <div class="form-group">
                <label for="snid">SN</label>
                <input type="text" name="sn" class="form-control" id="snid" placeholder="查询设备SN" value="${param.sn}">
            </div>

            <div class="form-group" style="margin-left: 15px;">
                <label for="nameid">名称</label>
                <input type="text" name="alias" class="form-control" id="nameid" placeholder="查询设备名称" value="${param.alias}">
            </div>
        </form>
        <div class="pull-right"><button id="subBT" type="button" class="btn btn-default">查询</button></div>
    </div>
    <button class="btn btn-primary ldgbtmarginbottom5" id="addDevice" type="button">新增</button>
    <div class="table-responsive">
        <table class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <th>sn</th>
                <th>名称</th>
                <th>激活状态</th>
                <th>报废状态</th>
                <th>入库时间</th>
                <th>使用状态</th>
                <th>使用人</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="obj">
                <tr>
                    <td>${obj.sn}</td>
                    <td>${obj.alias}</td>
                    <td>
                        <c:if test="${obj.enable==1}"><span style="color: green">是</span></c:if>
                        <c:if test="${obj.enable==2}"><span style="color: red">否</span></c:if>
                    </td>
                    <td>
                        <c:if test="${obj.destroy==0||obj.destroy==1}">否</c:if>
                        <c:if test="${obj.destroy==2}"><span style="color: red">是</span></c:if>
                    </td>
                    <td>
                        <fmt:formatDate value="${obj.createtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                    </td>
                    <td>
                        <c:if test="${obj.returnstate==1}">
                            借出中
                        </c:if>
                        <c:if test="${obj.returnstate!=1}">
                            空闲
                        </c:if>
                    </td>
                    <td>
                            ${obj.patientname}
                    </td>
                    <td>
                        <a class="label label-info" ajaxthispage
                           href="/deviceHandler/editDevice?uid=${obj.uid}">编辑</a>
                        <a
                                <c:if test="${obj.destroy==2}">preventInfo="已报废！"</c:if> class="label label-warning"
                                ajaxdel alertMSG="<c:if test="${obj.landlogid!=null}">有绑定用户！</c:if>确定报废吗？"
                                href="/deviceHandler/destroyDeviceById?uid=${obj.uid}&sn=${obj.sn}">报废</a>
                        <a  <c:if test="${obj.returnstate!=1}">
                            preventInfo="未绑定，不需要解绑！"
                        </c:if> class="label label-success" ajaxdel
                                alertMSG="<c:if test="${obj.landlogid!=null}">有绑定用户！</c:if>确定解绑吗？"
                                href="/deviceHandler/unbindDeviceById?uid=${obj.uid}&sn=${obj.sn}">解绑</a>
                    </td>
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
    <input id="loadDataURL" type="hidden" value="/deviceHandler/deviceList"/>
    <input id="searFormID" type="hidden" value="subForm"/>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jsppage/device/devicelist.js"></script>