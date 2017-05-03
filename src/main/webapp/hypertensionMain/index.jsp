<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="utf-8">
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
    <title>随访管理</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="assets/css/templatemo_main.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css">
</head>
<body>
<input type="hidden" id="basePath" value="${pageContext.request.contextPath }/"/>
<div class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
        <div class="logo">
            <img src="assets/images/logo.png">
        </div>
    </div>
    <div class="pull-right">
        <div class="person_a">
            <label>你好，</label>
            <div class="btn-group">
                <button type="button" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false">${sessionScope.user.name} <span class="caret"></span></button>
                <ul class="dropdown-menu" style=" min-width:100px;">
                    <li><a ajaxhref href="/followupDisplay/updatePass.jsp">修改密码</a></li>
                    <li><a href="sdeyfollowup/loginOut">退出</a></li>
                </ul>
            </div>
        </div>
    </div>
    <!--btn-group结束-->

</div>
<div class="template-page-wrapper">
    <div class="navbar-collapse collapse templatemo-sidebar">
        <ul class="templatemo-sidebar-menu">
            <!-- <li>
               <form class="navbar-form">
                 <input type="text" class="form-control" id="templatemo_search_box" placeholder="Search...">
                 <span class="btn btn-default">go</span>
               </form>
             </li>-->
            <li class="active"><a href="javascript:;"><i class="fa fa-home"></i>首页</a></li>
            <li class="sub open"><a href="javascript:;"><span class="glyphicon glyphicon-calendar btn-lg"></span> 业务管理
                <div class="pull-right tt"><span class="caret"></span></div>
            </a>
                <ul class="templatemo-submenu">
                    <li><a id="cysfID" href="/webHandler/hypertensionListByUser"><span
                            class="glyphicon glyphicon-list-alt"></span>血压记录</a>
                    </li>

                </ul>
            </li>
            <li class="sub"><a href="javascript:;"><span class="glyphicon glyphicon-th-list btn-lg"></span>资讯管理
                <div class="pull-right tt"><span class="caret"></span></div>
            </a>
                <ul class="templatemo-submenu">
                    <li><a id="lbtID" href="/webHandler/lunbotuList"><span class="glyphicon glyphicon-list-alt"></span>轮播图</a>
                    </li>
                    <li><a href="/webHandler/faq_list"><span
                            class="glyphicon glyphicon-indent-left"></span>常见问题</a></li>
                    <li><a href="/sdeyfollowup/getManagerList"><span class="glyphicon glyphicon-user"></span>健康咨询</a>
                    </li>
                    <li><a href="/sdeyfollowup/getNoPageManagerList"><span
                            class="glyphicon glyphicon-th"></span>意见反馈</a></li>
                    <li><a href="/sdeyfollowup/msgModelList"><span
                            class="glyphicon glyphicon-th"></span>免责声明</a></li>
                </ul>
            </li>
            <c:if test="${sessionScope.user.name=='超级管理'}">
                <li class="sub"><a href="javascript:;"><span class="glyphicon glyphicon-th-list btn-lg"></span>数据管理
                    <div class="pull-right tt"><span class="caret"></span></div>
                </a>
                    <ul class="templatemo-submenu">
                        <li><a href="/sdeyfollowup/enterOneMonthHisChuYuanPatient"><span
                                class="glyphicon glyphicon-indent-left"></span>数据获取</a></li>
                        <li><a href="/sdeyfollowup/getManagerList"><span class="glyphicon glyphicon-user"></span>管理员</a>
                        </li>
                        <li><a href="/sdeyfollowup/getNoPageManagerList"><span
                                class="glyphicon glyphicon-th"></span>工作分配</a></li>
                        <li><a href="/sdeyfollowup/msgModelList"><span
                                class="glyphicon glyphicon-th"></span>短信模版</a></li>
                    </ul>
                </li>
            </c:if>
        </ul>
    </div>
    <!--/.navbar-collapse -->

    <div class="templatemo-content-wrapper">
        <div class="templatemo-content-title">
            <ol id="titleBarID" class="breadcrumb">
                <li><a href="javascript:;">首页</a></li>
                <li><a href="javascript:;" id="v1ID"></a></li>
                <li class="active" id="v2ID"></li>
            </ol>
        </div>
        <div id="mainContent" class="templatemo-content" style="min-height:795px;">

        </div>
    </div>
</div>
</div>
<footer class="templatemo-footer">
    <div class="templatemo-copyright">
        <p>Copyright &copy; 邦尼集团</p>
    </div>
</footer>
</div>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jquery-3.2.0.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap3.3.7.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/templatemo_script.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/moment.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap-datetimepicker.min.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/layer/layer.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/common.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxsessiontimeout.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/hypertensionMain/index.js"></script>
</body>
</html>