<%--
name:情シ専3B22 福永利恵
date:2017/06/09
comm:管理者ログインページ

暫定です。担当の人が自由に変更してください。
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.min.css" />
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>

<body>
<div class="center">
<div class="container">
	<h1>ログインページ（管理者用)</h1>
	</div>
	<div class="container">
		<!--  Loginサーブレットに送信 -->
		<form action="<%=request.getContextPath()%>/ManagerLoginServlet" method="post" >
			<div class="center-block">
				<label>ユーザーID</label>
				<div class="row">
					<div class="col-xs-3">
						<input type="text" name="userID" class="form-control" placeholder="ユーザーID">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label>パスワード</label>
				<div class="row">
					<div class="col-xs-3">
						<input type="password" name="password" class="form-control" placeholder="パスワード">
					</div>
				</div>
			</div>
			<button type="submit">ログイン</button>
		</form>
	</div>
	</div>
</body>
</html>