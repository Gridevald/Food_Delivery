<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta charset="utf-8">
	<title>Ресторан "Волшебная кухня"</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/myStyle.css">
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

	<div class="main_frame"><p align="center">Корзина</p></div><br><br>
	
	<table class="content_table">
		<tr>
			<th class="content_td">
				<span>Позиция</span>
			</th>
			<th class="content_td">
				<span>Название</span>
			</th>
			<th class="content_td">
				<span>Количество</span>
			</th>
			<th class="content_td">
				<span>Цена</span>
			</th>
		</tr>
		<c:forEach var="mDish" items="${sessionScope.cart}" varStatus="status">
			<tr>
				<td class="content_td">
					<c:out value="${status.count}" />
				</td>
				<td class="content_td">
					<c:out value="${mDish.key.name}" />
				</td>
				<td class="content_td">
					<c:out value="${mDish.value}" />
				</td>
				<td class="content_td">
					<c:out value="${mDish.key.price*mDish.value}" /> руб.
				</td>
				<td class="content_td" align="center">
					<form action="${pageContext.request.contextPath}/controller/removeFromCart" method="POST">
						<input type="hidden" name="dishName" value="${mDish.key.name}">
						<input type="submit" value="X">
					</form>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td class="content_td" colspan="3">
				<span>Сумма итого:</span>
			</td>
			<td class="content_td">
				<span>${sessionScope.sum} руб.</span>
			</td>
		</tr>
	</table>

	<br>

	<form action="${pageContext.request.contextPath}/controller/makeOrder" method="POST">
		<div align="center"><input type="submit" value="Оформить доставку"></div>
	</form>

	<div align="center">${cartError}</div>

</body>
</html>
