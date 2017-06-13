<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap.min.css" />
<title>科目登録</title>
</head>
<body>
<div class="container">

	<h1>週間スケジュール</h1>
	</div>
	<div class="container">
		<!--  Loginサーブレットに送信 -->
		<form action="<%=request.getContextPath()%>/ManagerLoginServlet" method="post" >
			<div class="center-block">
				<label>分類名</label>
				<div class="row">
					<div class="col-xs-3">
						<input type="text" name="userID" class="form-control" placeholder="ユーザーID">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label>科目名</label>
				<div class="row">
					<div class="col-xs-3">
						<input type="text" name="seminer_name" class="form-control" placeholder="科目名">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label>担当ID</label>
				<div class="row">
					<div class="col-xs-3">
						<input type="text" name="teacherid" class="form-control" placeholder="担当ID">
					</div>
				</div>
			</div>
			<button type="submit">登録</button>
		</form>
	</div>
</body>
</html>