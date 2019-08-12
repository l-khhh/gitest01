<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>사원 관리</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">

<!-- jQuery  -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- bootstrap CSS -->
<link
	href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet">

<script>
	var data=${json};
	var tmp = JSON.stringify(data);
	document.write("초기데이터"+tmp+"<br>");
	var str = tmp.replace(/\"/gi,"");
	str=str.replace(/\[/gi,"");
	str=str.replace(/\{/gi,"");
	str=str.replace(/\}/gi,"");
	str=str.replace(/\]/gi,"");
	str=str.replace(/name/gi,"");
	str=str.replace(/id/gi,"");
	str=str.replace(/:/gi,"");
	document.write("따옴표변환데이터"+str+"<br>");
	
	var arr = new Array();
	
	arr=str.split(",");
	for(var i=0;i<arr.length;i++){
		document.write("arr[i] >>" +arr[i]+"<br>");
	}
</script>

<iframe width=800 name="por" width="0" height="0" frameborder="0" scrolling="no"></iframe>
<form name="frm" method="post" action=""></form>
<script language=javascript>
frm.target = "por"; // iframe의 이름
frm.action = "userList.jsp?id="+id+"name="+name;
frm.submit();
</script>
</head>
<body>
<%
String id = request.getParameter("id").trim();
String name = request.getParameter("name").trim();
%>


	<div class="container">
		<h2 class="text-center">사원 목록</h2>
		<br>
		<p align=right>
			<a href="insertUserForm.do">사용자 등록</a>
		</p>

		<table id="employee" class="table table-bordered table table-hover">
			<thead>

				<tr>
					<th>아이디</th>
					<th>이름</th>

					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
					
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td><a href="updateUserForm.do?id=${user.id}">수정</a></td>
						<td><a href="deleteUser.do/${user.id}">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<script>
			// 테이블의 Row 클릭시 값 가져오기
			$("#employee tr")
					.dblclick(
							function() {
								// 현재 클릭된 Row(<tr>)
								var tr = $(this);
								var td = tr.children();
								// 반복문을 이용해서 배열에 값을 담아 사용할 수 도 있다.

								// td.eq(index)를 통해 값을 가져올 수도 있다.
								var userId = td.eq(0).text();
								//var name = td.eq(1).text();

								//더블 클릭시 선택된 행의 id값을 주키로 select.jsp페이지를 호출한다.
								window
										.open('getUser.do?id=' + userId, '조회',
												'width=400, height=300, menubar=no, status=no, toolbar=no');
							});
		</script>
	</div>

</body>
</html>