<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap.min.css" />
<title>管理者</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/ToG204">科目登録</a>

=======
<jsp:include page="Gheader.jsp"/>
<div class="container">
	<h1><p class="text-primary"><c:out value="${subject_name}" />ゼミ受講学生一覧</p></h1>
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