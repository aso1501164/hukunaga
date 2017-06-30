<%--
name:情シ専3B22 福永利恵
date:2017/06/6
comm:インデックスページ
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
h1 {
	position: relative;
	width:500px;
	padding: .5em .75em;
	background-color: #f0f0f0;
	border-radius: 6px;
	box-shadow: 4px 4px 6px rgba(0, 0, 0, .1) inset;
    background-color: rgba( 255, 255, 255, 0.6 );
    color: #000000;
}
</style>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap.min.css" />
<title>ゼミ受講システム</title>
<script type="text/javascript">
</script>
</head>

<body  background="img/140704wall1b.jpg">
<div class="center">
	<div class="container">

	<h1><font color="#555555">ゼミ受講システム</font></h1>
	</div>
	<div class="container">
		<div class="col-sm-10">
			<form action="ToG106" method="post">
			<input type="submit" value="test"></form>
			<p>
				<a href="<%=request.getContextPath()%>/ToG101" class="btn btn-default btn-lg"><i class="glyphicon glyphicon-pencil"></i>生徒用ログインページ</a>
			</p>
			<p>
				<br>
				<a href="<%=request.getContextPath()%>/ToG201" class="btn btn-default btn-lg"><i class="glyphicon glyphicon-pencil"></i>管理用ログインページ</a>
		</div>
	</div>
	</div>
</body>
</html>