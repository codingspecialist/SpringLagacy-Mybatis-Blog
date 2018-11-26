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
<h1>가는날</h1>
<c:forEach var="item" items="${go}">
	항공사 : ${item.airlineNm}<br>
	출발지 : ${item.arrAirportNm}<br>
	출발시간 : ${item.arrPlandTime}<br>
	도착지 : ${item.depAirportNm}<br>
	도착시간 : ${item.depPlandTime}<br>
	가격 : ${item.economyCharge}<br>
	비니지스석 : ${item.prestigeCharge}<br>
	비행기번호 : ${item.vihicleId}<br>
</c:forEach>
<h1>오는날</h1>
<c:forEach var="item" items="${back}">
	항공사 : ${item.airlineNm}<br>
	출발지 : ${item.arrAirportNm}<br>
	출발시간 : ${item.arrPlandTime}<br>
	도착지 : ${item.depAirportNm}<br>
	도착시간 : ${item.depPlandTime}<br>
	가격 : ${item.economyCharge}<br>
	비니지스석 : ${item.prestigeCharge}<br>
	비행기번호 : ${item.vihicleId}<br>
</c:forEach>
</body>
</html>
