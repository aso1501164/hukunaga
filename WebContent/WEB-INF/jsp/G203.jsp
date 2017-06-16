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
<title>Insert title here</title>
<script type="text/javascript">
function linkclick (num) {
	//alert("linkclick in!：");
	   document.getElementById("seminar_id").value = num;
	   alert("セミナーidの値：" + document.getElementById("seminar_id").value);
	   document.formA.submit();
}

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
<body>
	<div class="center">
	<div class="container">
		<div class="col-sm-10">
		<h1>科目一覧</h1>
				<div class="form-group">
					<%-- seminar_idを伴ってStudentListServletに遷移 --%>
					<form class="form-group" name="formA" method="post" action="<%=request.getContextPath()%>/StudentListServlet">
						<table class="table table-bordered" cellpadding="0">
							<tr>
								<td class="active">教科名</td>
								<td class="active">　　　</td>
								<td class="active">　　　</td>
							</tr>
							<tr>
								<c:forEach var="su" items="${subject}" varStatus="status">
									<td><c:out value="${su.seminar_name}" /></td>
									<td><input type="submit" value="学生一覧" style="width: 90px"></td>
								</form>
									<input type="hidden" name="seminar_id" value="${su.seminar_id}">
								<td>
									<form name="deleteform" method="post" action="<%=request.getContextPath()%>/DeleteSeminarServlet" onsubmit="return submitChk()">
										<button type='submit' name='delete' style="width: 90px" value='${su.seminar_id}'>削除</button>
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