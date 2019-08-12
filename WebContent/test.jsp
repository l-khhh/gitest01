<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="org.json.simple.JSONArray" %>
<%@ page import ="org.json.simple.JSONObject" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

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
</head>

<body>
	<h2>test 페이지 a음.</h2>
	
	
	<p>
	</p>
</body>

</html>



<!-- 	JSONParser jsonParser =new JSONParser(); -->
	
<!-- 	JSONObject jsonObject = (JSONObject) jsonParser.parser(str); -->
	
<!-- 	JSONArray bookInfoArray = (JSONArray) jsonObject.get("person"); -->
	
<!-- 	JSONObject bookObject =(JSONObject) bookInfoArray.get(0); -->
	
<!-- 	document.write("id ======"+bookObject.get("id")+'<br>'); -->
<!-- 	document.write("nae ======"+bookObject.get("name")+'<br><br><br>'); -->
	
	