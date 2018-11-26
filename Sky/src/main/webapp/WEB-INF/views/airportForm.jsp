<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8" />
	<title>Home</title>
</head>
<body>
<form action="/sky/airport" method="POST">
	출발 : <input type="text" name="depAirportNm">
	도착 : <input type="text" name="arrAirportNm">
	가는날 : <input type="text" name="depPlandTime">
    오는날 : <input type="text" name="arrPlandTime">
    <input type="submit" value="전송">
</form>
</body>
</html>
