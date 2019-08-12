<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="EUC-KR">
<title>사원 등록</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">사원 등록</h2>
		<div>
			<form method="post" action="insertUser.do"  >
				<table  class="table table-bordered table table-hover">
					<tr>
						<td>아이디 :</td>
						<td><input type="text" name="id"  /></td>
					</tr>
					<tr>
						<td>이름 :</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>성별 :</td>
						<td><c:forEach var="sexName" items="${map.sexList}">
									<input type="radio" name="sex" value="${sexName}">${sexName}
							  </c:forEach></td>
					</tr>
					<tr>
						<td>직위 :</td>
						<td><select name="position">
								<c:forEach var="positionName" items="${map.positionList}">
									<option value="${positionName}">${positionName}</option>
								</c:forEach>
								</select></td>
					</tr>
					<tr>
						<td>부서 :</td>
						<td><input type="text" name="dept" /></td>
					</tr>
					<tr>
						<td>연봉 :</td>
						<td><input type="text" name="sal" /></td>
					</tr>
					<tr>
					<td colspan="2"  class="text-center">
						<input type="submit" value="등록"/></td>
					</tr>
					<tr>					
						<td colspan="2" class="text-center"><a href="getUserList.do">사용자 목록보기</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>