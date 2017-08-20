<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta charset="utf-8">
	<title>Ресторан "Волшебная кухня"</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/myStyle.css">
	<style type="text/css">
		h2 {
			font-weight: normal;
			color: #ff8000;
		}
		.menu_button {
			width: 300px;
			height: 100px;
			background: #ff9900;
			font-size: 40px;
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

	<div class="main_frame"><p align="center">Ресторан "Волшебная кухня"</p></div>

	<H2><p align="center">В нашем ресторане присутствует кухня различных культур и Вы сможете выбрать то, что Вам по душе!</p></H2>

	<form action="${pageContext.request.contextPath}/controller/menu" method="POST">
		<p align="center"><input type="submit" value="Меню" class="menu_button"></p>
	</form>

</body>
</html>
