<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>


    <button class="btn btn-primary ldgbtmarginbottom5" id="addPatient" type="button">新增</button>

    <div class="table-responsive">
        <table class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <th>姓名</th>
                <th>手机</th>
                <th>性别</th>
                <th>年龄</th>
                <th>SN</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="obj">
                <tr>
                    <td>${obj.name}</td>
                    <td>${obj.registphone}</td>
                    <td>
                            ${obj.sex}
                    </td>
                    <td>
                            ${obj.age}
                    </td>
                    <td>

                        <c:if test="${obj.sn!=null}">
                            ${obj.sn}
                        </c:if>
                        <c:if test="${obj.sn==null||fn:length(fn:trim(obj.sn))==0}">
                            <span style="color: red">未绑定</span>
                        </c:if>
                    </td>
                    <td>
                        <a class="label label-info" ajaxthispage
                           href="/webPatientHandler/patientBindDeviceByUid?patientid=${obj.uid}">编辑</a>
                        <a class="label label-success" ajaxLayerWindowFrame title="绑定记录" width="1000" height="600"
                           href="/webPatientHandler/patientBindDeviceLogsByUid?patientid=${obj.uid}">绑定记录</a>
                        <a class="label label-warning" ajaxLayerWindowFrame title="【${obj.name}】测量数据" width="1000" height="600"
                           href="/webPatientHandler/getpatientBindDeviceDataByDeviceSNAndPatientID?devicesn=${obj.sn}&patientid=${obj.uid}">测量数据</a>
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
<script language="javascript" type="text/javascript" src="assets/js/jsppage/patient/list.js"></script>