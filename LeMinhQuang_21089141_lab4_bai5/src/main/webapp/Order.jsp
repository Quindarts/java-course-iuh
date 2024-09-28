<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="order.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<header class="text-center mb-6">
			<h1 class="title">IUH BOOKSTORE</h1>
			<nav class="mt-4">
				<a href="#" class="nav-link">Home</a> <a href="#" class="nav-link">Examples</a>
				<a href="#" class="nav-link">Services</a> <a href="#"
					class="nav-link">Products</a> <a href="#" class="nav-link">Contact</a>
			</nav>
		</header>
		<div class="content">
			<div class="sidebar">
				<h2 class="section-title">ABOUT US</h2>
				<p>
					About us information will be here... <a href="#" class="read-more">Read
						More &raquo;</a>
				</p>
				<h2 class="section-title">SEARCH SITE</h2>
				<input type="text" class="search-input" placeholder="Search..." />
			</div>

			<div class="main">
				<h2 class="checkout-title">Checkout - Already registered?</h2>
				<form method="post" action="payment">
					<div class="form-group">
						<label for="fullname" class="form-label">Fullname:</label> <input
							type="text" id="fullname" placeholder="Enter your fullname" name="fullname"
							class="form-input" />
					</div>
					<div class="form-group">
						<label for="address" class="form-label">Shipping address:</label>
						<input type="text" id="address" name="address"
							placeholder="Enter your shipping address" class="form-input" />
					</div>
					<c:forEach var="item" items="${sessionScope.cart}">
						<c:set var="total"
							value="${total + item.book.price * item.quantity}"></c:set>
					</c:forEach>
					<div class="form-group">
						<label for="total-price" class="form-label">Total price: </label>
						<input type="text" id="total-price" value="${total}" name="total" readonly
							class="form-input" />
					</div>
					<div class="form-group">
						<label class="form-label">Payment method:</label>
						<div class="payment-option">
							<input type="radio" id="paypal" name="payment-method"
								value="paypal" class="payment-input" name=""/> <label for="paypal"
								class="payment-label">Paypal</label>
						</div>
						<div class="payment-option">
							<input type="radio" id="atm" name="payment-method" value="atm"
								class="payment-input" /> <label for="atm" class="payment-label">ATM
								Debit</label>
						</div>
						<div class="payment-option">
							<input type="radio" id="visa" name="payment-method" value="visa"
								class="payment-input" /> <label for="visa"
								class="payment-label">Visa/Master card</label>
						</div>
					</div>
					<div class="button-group">
						<button type="submit" class="btn save-btn">Save</button>
						<button type="button" class="btn cancel-btn">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>