<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>��� ���� ����</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">��� ���� ����</h2>
		<div>
			<form method="post" action="updateUser.do">
				<input type="hidden" name="id"  value="${map.user.id}" />
				<table class="table table-bordered table table-hover">
					<tr>
						<td>���̵� :</td>
						<td>${map.user.id}</td>
					</tr>
					<tr>
						<td>�̸� :</td>
						<td><input type="text" name="name" value="${map.user.name}" />
						</td>
					</tr>
					<tr>
						<td>���� :</td>
						<td>
								<c:forEach items='${map.sexList}' var='sexName'>
									<c:choose>
										<c:when test="${sexName eq map.user.sex}">
											<input type="radio" name="sex" value="${sexName}"
												checked="checked">${sexName}
										</c:when>
										<c:otherwise>
											<input type="radio" name="sex" value="${sexName}">${sexName}
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</td>
					</tr>
					<tr>
						<td>���� :</td>
						<td>
								<select name="position">
									<c:forEach items='${map.positionList}' var='positionName'>
										<c:choose>
											<c:when test="${positionName eq map.user.position}">
												<option value="${positionName}" selected>${positionName}</option>
											</c:when>
											<c:otherwise>
												<option value="${positionName}">${positionName}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
						</td>
					</tr>
					<tr>
						<td>�μ� :</td>
						<td><input type="text" name="dept" value="${map.user.dept}" /></td>
					</tr>
					<tr>
						<td>���� :</td>
						<td><input type="text" name="sal" value="${map.user.sal}"/></td>
					</tr>
					
					<tr>
						<td colspan="2" class="text-center"><input type="submit" value="����" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>