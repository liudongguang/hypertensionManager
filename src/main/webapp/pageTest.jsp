<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <base href="${pageContext.request.contextPath }/" />
  <meta charset="utf-8">
  <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
  <title>随访管理</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="assets/css/templatemo_main.css">
  <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<input type="hidden" id="basePath" value="${pageContext.request.contextPath }/"/>
<!--
    分页开始
-->
<div id="pagesDIV"></div>
<input id="pageNum" type="hidden" value="2"/>
<input id="pageSize" type="hidden" value="5"/>
<input id="total" type="hidden" value="70"/>
<!--
    分页结束
-->
<script language="javascript" type="text/javascript" src="assets/js/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/templatemo_script.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/layer/layer.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/common.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
</body>
</html>