<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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

	<div class="main_frame"><p align="center">Оформление заказа</p></div><br><br>
	
	<form action="${pageContext.request.contextPath}/controller/final" method="POST">
		<table>
			<tr>
				<td>Имя:</td>
				<td><input type="text" name="name" placeholder="Имя" size="30" value="${name}"></td>
			</tr>
			<tr>
				<td>Адрес:</td>
				<td><input type="text" name="address" placeholder="Адрес" size="30" value="${address}"></td>
			</tr>
			<tr>
				<td>Тел. номер:</td>
				<td><input type="text" name="number" placeholder="Телефон(+375-ХХ-ХХХ-ХХ-ХХ)" size="30" value="${number}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Заказать!"></td>
			</tr>
		</table>
	</form>

	<div align="center">${orderError}</div>

	<!-- Надо бы сделать проверку валидности введённых данных, 
	но в данном учебном проекте это не имеет смысла, т.к. нет установленной
	базы адресов доставки и проверка заказа должна осуществляться менеджером.
	Осуществлена проверка на пустые поля и формат введённого номера телефона. -->

</body>
</html>
