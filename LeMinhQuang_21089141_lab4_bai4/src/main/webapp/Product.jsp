<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Product Page</title>
<style>
body {
	display: flex;
	flex-direction: column;
	min-height: 100vh;
	font-family: Arial, sans-serif;
	background-color: #f8fafc; /* Màu nền nhẹ (bg-gray-100) */
}

header {
	background-color: #3b82f6; /* Màu xanh (bg-blue-500) */
	padding: 20px;
}

.navbar-brand a {
	color: white; /* Màu chữ trắng */
	text-decoration: none;
	font-size: 24px;
}

.container {
	width: 80%;
	margin: 20px auto;
	padding: 20px;
	background: white;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

h3 {
	text-align: center;
	margin: 20px 0;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 20px 0;
}

th, td {
	border: 1px solid #e5e7eb; /* Màu border (border-gray-300) */
	padding: 10px;
	text-align: center;
}

th {
	background-color: #3b82f6; /* Màu xanh (bg-blue-500) */
	color: white; /* Màu chữ trắng */
}

img {
	width: 120px;
	height: auto;
}

a {
	color: #3b82f6; /* Màu xanh (text-blue-500) */
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<header>
		<nav class="navbar">
			<div class="navbar-brand">
				<a href="<%=request.getContextPath()%>/Cart.jsp">Sample Shopping LMQ</a>
			</div>
		</nav>
	</header>
	<div class="container">
		<h3>List of Products</h3>
		<hr>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Photo</th>
					<th>Price</th>
					<th>Buy</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td><img
							src="${pageContext.request.contextPath}/resources/images/${product.image}">
						</td>
						<td>${product.price}</td>
						<td><a
							href="${pageContext.request.contextPath}/cart?action=buy&id=${product.id}">Buy</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
