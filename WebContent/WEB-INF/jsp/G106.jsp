<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1>履修履歴</h1>
	<div align="center">
		<table border=1>
			<c:if test="${!empty History }">
				<c:forEach var="history" items="${History }">
				<tr>
				<td><c:out value="${history.year }"></c:out></td>
				<td><c:out value="・科目名：${history.subject_name_1}"></c:out></td>
				</tr>
				<tr>
				<td></td>
				<td><c:out value="・科目名：${history.subject_name_2}"></c:out></td>
				</tr>

				</c:forEach>
			</c:if>
		</table>

	</div>

	<c:if test="${empty History }">
		<c:out value="${message }" />
	</c:if>
	<input type="button" Value="戻る" onClick="history.go(-1);">
</body>
</html>