<%--
name:情シ専3B22 福永利恵
date:2017/06/09
comm:科目編集画面（管理者用）
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
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
<link rel="stylesheet" href="bootstrap.min.css" />
<title>Insert title here</title>
<script type="text/javascript">
function linkclick (num) {
	//alert("linkclick in!：");
	   document.getElementById("subject_id").value = num;
	  // alert("weekの値：" + document.getElementById("subject_id").value);
	   document.formA.submit();
}

</script>

<script type="text/javascript">
<%-- 「削除」ボタンクリック時の確認メッセージ表示用スクリプト--%>
/**
 * 確認ダイアログの返り値によりフォーム送信
 */
function submitChk() {
	/* 確認ダイアログ表示 */
	var flag = confirm("削除してよろしいですか");
	/* send_flg が TRUEなら送信、FALSEなら送信しない */
	return flag;
}

</script>
</head>
<body  background="img/wall6b.jpg">
	<c:if test="${Permission == '0'}" var="flg" />
	<c:if test="${flg}">
		<!-- 権限が担任なら -->
		<jsp:include page="header_T.jsp" />
	</c:if>

	<c:if test="${!flg}">
		<!-- 権限が管理者なら -->
		<jsp:include page="header_M.jsp" />
	</c:if>
	<div class="center">
		<div class="container">
			<div class="col-sm-10">
				<h1><font color="#555555">科目一覧</font></h1>
				<div class="form-group">
					<%-- seminar_idを伴ってStudentListServletに遷移 --%>
					<form name="formA" method="post" action="<%=request.getContextPath()%>/StudentListServlet">
						<table class="table table-bordered" cellpadding="0">
							<tr>
								<td class="active">分野名</td>
								<td class="active">教科名</td>
								<td class="active"></td>
								<td class="active"></td>
							</tr>
							<tr>
								<c:forEach var="su" items="${subject}" varStatus="status">
									<td bgcolor="#ffffff"><c:out value="${su.classification_name}" /></td>
									<td bgcolor="#ffffff"><c:out value="${su.subject_name}" /></td>
									<td bgcolor="#ffffff"><a href="javascript:void(0);"
										onclick="javascript:linkclick(${su.subject_id})">学生一覧</a></td>
									<input type="hidden" name="subject_id" value="${su.subject_id}"
										id="subject_id">
									</form>
									<td bgcolor="#ffffff">
										<form name="deleteform" method="post" action="<%=request.getContextPath()%>/DeleteSeminarServlet" onsubmit="return submitChk()">
											<button class="btn btn-danger" type='submit' name='delete' style="width: 90px" value='${su.subject_id}'>削除</button>
										</form>
									</td>
							</tr>
							</c:forEach>
						</table>
						<br>
				</div>
			</div>
		</div>
	</div>
</body>
</html>