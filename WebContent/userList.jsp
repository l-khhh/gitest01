<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>��� ����</title>
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
	document.write("�ʱⵥ����"+tmp+"<br>");
	var str = tmp.replace(/\"/gi,"");
	str=str.replace(/\[/gi,"");
	str=str.replace(/\{/gi,"");
	str=str.replace(/\}/gi,"");
	str=str.replace(/\]/gi,"");
	str=str.replace(/name/gi,"");
	str=str.replace(/id/gi,"");
	str=str.replace(/:/gi,"");
	document.write("����ǥ��ȯ������"+str+"<br>");
	
	var arr = new Array();
	
	arr=str.split(",");
	for(var i=0;i<arr.length;i++){
		document.write("arr[i] >>" +arr[i]+"<br>");
	}
</script>

<iframe width=800 name="por" width="0" height="0" frameborder="0" scrolling="no"></iframe>
<form name="frm" method="post" action=""></form>
<script language=javascript>
frm.target = "por"; // iframe�� �̸�
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
		<h2 class="text-center">��� ���</h2>
		<br>
		<p align=right>
			<a href="insertUserForm.do">����� ���</a>
		</p>

		<table id="employee" class="table table-bordered table table-hover">
			<thead>

				<tr>
					<th>���̵�</th>
					<th>�̸�</th>

					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
					
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td><a href="updateUserForm.do?id=${user.id}">����</a></td>
						<td><a href="deleteUser.do/${user.id}">����</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<script>
			// ���̺��� Row Ŭ���� �� ��������
			$("#employee tr")
					.dblclick(
							function() {
								// ���� Ŭ���� Row(<tr>)
								var tr = $(this);
								var td = tr.children();
								// �ݺ����� �̿��ؼ� �迭�� ���� ��� ����� �� �� �ִ�.

								// td.eq(index)�� ���� ���� ������ ���� �ִ�.
								var userId = td.eq(0).text();
								//var name = td.eq(1).text();

								//���� Ŭ���� ���õ� ���� id���� ��Ű�� select.jsp�������� ȣ���Ѵ�.
								window
										.open('getUser.do?id=' + userId, '��ȸ',
												'width=400, height=300, menubar=no, status=no, toolbar=no');
							});
		</script>
	</div>

</body>
</html>