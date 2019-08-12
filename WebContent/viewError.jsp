<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page isErrorPage = "true" %>
<html>
<head><title>에러 발생</title></head>
<body>
요청 처리 과정에서 에러가 발생하였습니다.<br>
<p>
에러 타입: <%= exception.getClass().getName() %> <br>
에러 메시지: <b><%= exception.getMessage() %></b>
<hr>

</body>
</html>

