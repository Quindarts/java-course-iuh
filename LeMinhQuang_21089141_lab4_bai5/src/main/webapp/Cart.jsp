<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="cartStyles.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1 class="title">IUH BOOKSTORE</h1>
		<nav class="nav">
			<ul class="nav-list">
				<li><a href="#" class="nav-link">Home</a></li>
				<li><a href="#" class="nav-link">Examples</a></li>
				<li><a href="#" class="nav-link">Services</a></li>
				<li><a href="${pageContext.request.contextPath}/books"
					class="nav-link">Products</a></li>
				<li><a href="#" class="nav-link">Contact</a></li>
			</ul>
		</nav>
		<div class="content">
			<div class="sidebar">
				<h2 class="section-title">ABOUT US</h2>
				<p>
					About us information will be here... <a
						href="${pageContext.request.contextPath}/books" class="read-more">Read
						More &raquo;</a>
				</p>
				<h2 class="section-title">SEARCH SITE</h2>
				<input type="text" class="search-input" placeholder="Search..." />
			</div>

			<div class="main">
				<h2 class="section-title">YOUR SHOPPING CART</h2>
				<table class="cart-table">
					<thead>
						<tr class="table-header">
							<th>Product ID</th>
							<th>Product name</th>
							<th>Price</th>
							<th>Qty</th>
							<th>Total</th>
							<th>Remove</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${sessionScope.cart}">
							<c:set var="total"
								value="${total + item.book.price * item.quantity}"></c:set>

							<tr>
								<td>${item.book.code}</td>
								<td>${item.book.title}-${item.book.author}</td>
								<td>${item.book.price}</td>
								<td>${item.quantity}</td>
								<td>${item.book.price * item.quantity}</td>

								<td><a
									href="${pageContext.request.contextPath}/cart?action=remove&id=${item.book.bookId}"
									onclick="return confirm('Are you sure?')" class="remove-link">Remove</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="total">
					<p class="total-price">Total price (VND) ${total}</p>
				</div>
				<div class="button-group">
					<a class="checkout-button"
						href="${pageContext.request.contextPath}/cart?action=payment">Checkout</a>
					<a href="${pageContext.request.contextPath}/books"
						class="continue-button">Continue shopping</a>
				</div>
			</div>
		</div>
		<footer class="footer">
			<p>&copy; IUH Bookstore 2016. All rights reserved.</p>
		</footer>
	</div>

</body>
</html>