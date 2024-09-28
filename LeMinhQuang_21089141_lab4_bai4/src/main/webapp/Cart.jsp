<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
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
	margin: 0 auto;
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

.total-row {
	font-weight: bold;
	color: #3b82f6; /* Màu xanh nhấn mạnh */
}
</style>
</head>
<body>
	<header>
		<nav class="navbar">
			<div class="navbar-brand">
				<a href="<%=request.getContextPath()%>">Sample Shopping</a>
			</div>
		</nav>
	</header>
	<div class="container">
		<h3>Shopping Carts</h3>
		<hr>
		<table>
			<thead>
				<tr>
					<th>Option</th>
					<th>Id</th>
					<th>Name</th>
					<th>Photo</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Sub Total</th>
				</tr>
			</thead>
			<c:set var="total" value="0"></c:set>
			<c:forEach var="item" items="${sessionScope.cart}">
				<c:set var="total"
					value="${total + item.product.price * item.quantity}"></c:set>
				<tr>
					<td><a
						href="${pageContext.request.contextPath}/cart?action=remove&id=${item.product.id}"
						onclick="return confirm('Are you sure?')">Remove</a></td>
					<td>${item.product.id}</td>
					<td>${item.product.name}</td>
					<td><img
						src="${pageContext.request.contextPath}/resources/images/${item.product.image}">
					</td>
					<td>${item.product.price}</td>
					<td>${item.quantity}</td>
					<td>${item.product.price * item.quantity}</td>
				</tr>
			</c:forEach>
			<tr class="total-row">
				<td colspan="6" align="right">Total</td>
				<td>${total}</td>
			</tr>
		</table>
		<h6 class="text-center">
			<a href="products">Continue Shopping</a>
		</h6>
	</div>
</body>
</html>
