<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta charset="utf-8">
	<title>Ресторан "Волшебная кухня"</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/myStyle.css">
	<style type="text/css">
		.name {
			font-size: 2em;
			color: red;
		}
	</style>
</head>
<body>

	<hr>
	<table>
		<tr>
			<td>
				<form action="${pageContext.request.contextPath}/controller/main" method="POST">
					<input type="submit" value="На главную">
				</form>
			</td>
			<td>
				<form action="${pageContext.request.contextPath}/controller/menu" method="POST">
					<input type="submit" value="Меню">
				</form>
			</td>
			<td>
				<form action="${pageContext.request.contextPath}/controller/cart" method="POST">
					<input type="submit" value="Корзина(${sessionScope.amount})">
				</form>
			</td>
		</tr>
	</table>
	<hr>

	<div class="main_frame"><p align="center">Меню</p></div><br><br>
	
	<table class="content_table">
		<c:forEach var="dish" items="${sessionScope.dishes}">
			<tr>
				<td class="content_td" width="410px">
					<img src="${pageContext.request.contextPath}${dish.picture}" alt="${dish.name}" width="400">
				</td>
				<td class="content_td" >
					<span class="name">${dish.name}</span><br>
					<c:out value="${dish.description}" />
				</td>
				<td  class="content_td" width="100px">
					<span>Цена:</span><br>
					<span>${dish.price} руб.</span><br>
					<form action="${pageContext.request.contextPath}/controller/addToCart" method="POST">
						<input type="hidden" name="dishName" value="${dish.name}">
						<input type="submit" value="В корзину!">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
