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
<body background="img/140704wall1b.jpg">
<jsp:include page="Gheader.jsp"/>
	<p>以下の内容でよろしいでしょうか</p>
	<form action="InsertSubject" method="post">
		<div align="center">
			<table border="1">
					<c:out value="・科目名：${Subjects[0]}"></c:out>
					<c:out value="・科目名：${Subjects[1]}"></c:out>
			</table>

		</div>

		<input type="button" Value="戻る" onClick="history.go(-1);"> <input
			type="submit" value="完了">
	</form>
</body>
</html>