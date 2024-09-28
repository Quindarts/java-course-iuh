<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style_bai3.css" />

</head>
<body>
	<c:set var="mangonngu" value="${param.radio_mangonngu}" />

	<form class="card-form"
		action="${pageContext.request.contextPath}/submit" method="post">
		<div class="card">
			<h2 class="title">Please select your language</h2>
			<div class="radio-group">
				<label> <input type="radio" name="language"
					value="vietnamese" /> Vietnamese
				</label> <label> <input type="radio" name="language" value="english"
					checked /> English
				</label>
				<button type="button" class="choose-button">Choose</button>
			</div>
			<div class="input-group">
				<label for="username" class="label">Username</label> <input
					type="text" id="username" name="username" class="input" />
			</div>
			<div class="input-group">
				<label for="password" class="label">Password</label> <input
					type="password" id="password" name="password" class="input" />
			</div>
			<button type="submit" class="login-button">Login</button>
		</div>
	</form>
</body>
</html>