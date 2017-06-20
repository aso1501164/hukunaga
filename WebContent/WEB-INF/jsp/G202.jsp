<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.min.css" />
<title>Insert title here</title>

</head>
<body>
<jsp:include page="Gheader.jsp"/>
	<h1><c:out value="${subject_name}" />ゼミ受講学生一覧</h1>
<div class="container">
	<table class="table table-bordered" cellpadding="0">
		<tr>
			<td class="active">学部</td>
			<td class="active">氏名</td>
		</tr>
		<c:forEach var="su" items="${student}" varStatus="status">
		<tr>
				<td><c:out value="${su.class_name}" /></td>
				<td><c:out value="${su.student_name}" /></td>
		</tr>
		</c:forEach>
	</table>
<form>
	<input type="button" value="このページを印刷する" onclick="window.print();" />
</form>
</div>
</body>
</html>