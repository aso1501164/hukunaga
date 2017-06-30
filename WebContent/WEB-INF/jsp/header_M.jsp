<%--
name:情シ専3B22 福永利恵
date:2017/06/09
comm:担任用header
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css" />
</head>
<body background="img/wall6b.jpg">
<div class="container">
<div class="row">
<br>
<div class="col-md-8"></div>
<div class="col-md-2"><a href="<%=request.getContextPath()%>/ToG204" class="btn btn-default" style="width: 90px">科目登録</a></div>
<div class="col-md-2"><form name="logout" method="post" action="<%=request.getContextPath()%>/Logout"><button class="btn btn-default" type="submit" style="width: 90px">ログアウト</button></form></div>
</div>
</div>
</body>
</html>