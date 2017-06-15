<%--
name:情シ専3B22 福永利恵
date:2017/06/09
comm:科目編集画面（管理者用）
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="col-sm-10">
		<h1>科目一覧</h1>
			<c:forEach var="su" items="${subject}" varStatus="status">
				<c:out value="${su.seminar_name}" /><br>
			</c:forEach>
		</div>
	</div>
</body>
</html>