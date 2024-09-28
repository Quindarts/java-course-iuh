<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>IUH BOOKSTORE</title>
<link rel="stylesheet" href="booksStyles.css">
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
		<div class="flex">
			<aside class="sidebar">
				<h2 class="sidebar-title">ABOUT US</h2>
				<p class="sidebar-text">
					About us information will be here... <a href="#"
						class="sidebar-link">Read More</a>
				</p>
				<h2 class="sidebar-title mt-4">SEARCH SITE</h2>
				<input type="text" class="search-input" placeholder="Search..." />
				<div class="cart-info mt-4">
					<h3 class="cart-title">Shopping cart (4)</h3>
				</div>
			</aside>
			<main class="main-content">
				<c:forEach var="book" items="${books}">
					<div class="product-card">
						<img class="product-image"
							src="${pageContext.request.contextPath}/resources/images/${book.imageUrl}" />

						<h3 class="product-title">
							<c:out value="${book.title}" />
							- Tác giả:
							<c:out value="${book.author}" />
						</h3>
						<p>
							Price:
							<c:out value="${book.price}" />
							VND
						</p>
						<p>
							Quantity:
							<c:out value="${book.quantity}" />
						</p>
						<a
							href="${pageContext.request.contextPath}/books?action=details&id=${book.bookId}"
							class="product-link">Product details</a> <a class="add-to-cart"
							href="${pageContext.request.contextPath}/cart?action=buy&id=${book.bookId}">Add
							to cart</a>
					</div>
				</c:forEach>

			</main>
		</div>
	</div>
</body>
</html>
