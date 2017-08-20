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
		</tr>
	</table>
	<hr>

	<div class="main_frame"><p align="center">Спасибо за заказ!</p></div><br><br>

	<div align="center">Благодарим за выбор нашей доставки!<br>
	В ближайшее время с Вами свяжется наш оператор для подтверждения заказа и уточнения данных.</div>

</body>
</html>
