<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Id Not Found</title>
</head>
<body>
Id  <%=request.getAttribute("id") %> not found. Please try again<br>
<b> <a href="http://localhost:8080/RetrieveId/index.jsp">Try Again</a></b></center>
</body>
</html>