<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap.min.css" />
<title>科目登録</title>
</head>
<body background="img/wall6b.jpg">
<div class="container">

<h1>週間スケジュール</h1><!--
<table>
<c:forEach var="su" items="${sessionScope.classification}" varStatus="status">
    <tr>
        <td><c:out value="${su.classfication_name}"></c:out></td>
    </tr>
</c:forEach>
</table>

<table>
<c:forEach var="su" items="${sessionScope.classification}" varStatus="status">
    <tr>
        <td><c:out value="${su.classfication_id}"></c:out></td>
    </tr>
</c:forEach>
</table>
-->

</div><div class="container"><!--  Loginサーブレットに送信 --><form action="<%=request.getContextPath()%>/Registration" method="post" ><div class="center-block"><label>分類名</label><div class="row"><div class="col-xs-3"><select name="classfication"><c:forEach var="su" items="${sessionScope.classification}" varStatus="status"><option value="${su.classfication_id}"><c:out value="${su.classfication_name}"></c:out></option></c:forEach></select></div></div></div><div class="form-group"><label>科目名</label><div class="row"><div class="col-xs-3"><input type="text" name="subject_name" class="form-control" placeholder="科目名"></div></div></div><div class="form-group"><label>担当ID</label><div class="row"><div class="col-xs-3"><input type="text" name="manager_id" class="form-control" placeholder="担当ID"></div></div></div><button type="submit">登録</button></form></div>
</body>
</html>