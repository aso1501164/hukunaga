<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/ToG106" method="post">
<input type="submit" value="G106">
</form>
<form action="<%=request.getContextPath()%>/ToG104" method="post">
<input type="submit" value="G104">
</form>
<form action="<%=request.getContextPath()%>/ToG103" method="post">
<input type="submit" value="G103">
</form>
<c:if test="${!empty ConfList}">
	<c:out value="${message}"/>
</c:if>
<input type="button" Value="戻る" onClick="history.go(-1);">

</body>
</html>