<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
    <button class="btn btn-primary" id="addfaq" type="button" pici="${pici}">新增</button>
    <div class="table-responsive">
        <table class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <th>标题</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="obj">
                <tr>
                    <td>${obj.title}</td>
                    <td><fmt:formatDate value="${obj.createtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td>
                        <a class="label label-info" ajaxthispage
                           href="/webHandler/editFAQ?uid=${obj.uid}&pici=${obj.imgpici}">编辑</a>
                        <a class="label label-warning" ajaxdel
                           href="/webHandler/delfaqById?uid=${obj.uid}&pici=${obj.imgpici}">删除</a>
                        <a class="label label-success" ajaxLayerWindowFrame title="预览常见问题"  width="500" height="600"
                           href="/webHandler/displayFAQ?uid=${obj.uid}">预览</a></td>
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
    <input id="loadDataURL" type="hidden" value="/webHandler/faq_list"/>
    <input id="searFormID" type="hidden" value="subForm"/>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/zixun/faq/index.js"></script>