<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��� ������</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	    <h2 class="text-center">��� ������</h2>
		<table class="table table-bordered table table-hover">
			<tr><td>���̵� :</td><td>${user.id}</td></tr>
			<tr><td>�̸� :</td><td>${user.name}</td></tr>
			<tr><td>���� :</td><td>${user.sex}</td></tr>
			<tr><td>���� :</td><td>${user.position}</td></tr>
			<tr><td>�μ� :</td><td>${user.dept}</td></tr>
			<tr><td>���� :</td><td>${user.sal}</td></tr>
			
		</table>
	</div>
</body>
</html>
