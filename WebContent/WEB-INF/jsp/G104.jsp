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
<jsp:include page="Gheader.jsp"/>
   <c:if test="${empty ConfList}">
	<hr>
	<form action="ToG105" method="post">
		 
		<div align="center">
		<div id="target" style="color: red;">
		</div>

			<table border="1" class="table table-striped">
				<tr>
				<th>選択1</th>
					<td>                           
					<select name="subject_1">
					<c:forEach begin="0" items="${AllSelectList}" var="allselectlist">
					<option><c:out value="${allselectlist.subject_name }"></c:out></option>
					</c:forEach>
					</select>
					</td>
					</tr>

					<tr>

					<th>選択2</th>
					<td>                           
					<select name="subject_2">
					<c:forEach begin="0" items="${AllSelectList}" var="allselectlist">
					<option><c:out value="${allselectlist.subject_name }"></c:out></option>
					</c:forEach>
					</select>               
					</td>
					</tr>

				<tr>
				<td colspan="2">
						<center>
						 <input type="submit" value="申込">
						</center>                        
				</td>
				</tr>
			</table>
		</div>
		 
	</form>
</c:if>

</body>
</html>