<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="${pageContext.request.contextPath }/"/>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
<body>
  <form action="appHandler/modifyUserInfo" method="post" enctype="multipart/form-data">
	  name:<input name="name" value="aaaa"/>
	  file:<input type="file" name="mydddddddfile"/>
	  <button type="submit">提交</button>
  </form>
</body>
</html>