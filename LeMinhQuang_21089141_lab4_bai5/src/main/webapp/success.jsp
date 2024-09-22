<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đặt Hàng Thành Công</title>
<link rel="stylesheet" href="styles.css">
</head>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 20px;
}

.container {
	max-width: 600px;
	margin: 0 auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.header {
	text-align: center;
	margin-bottom: 20px;
}

.title {
	font-size: 24px;
	color: #333;
}

.main-content {
	text-align: left;
}

h2 {
	font-size: 20px;
	color: #0052b1;
}

ul {
	list-style-type: none;
	padding: 0;
}

li {
	margin: 10px 0;
	font-size: 16px;
}

strong {
	color: #333;
}

.btn {
	display: inline-block;
	padding: 10px 20px;
	margin-top: 20px;
	background-color: #0052b1;
	color: #fff;
	text-decoration: none;
	border-radius: 5px;
	transition: background-color 0.3s;
}

.btn:hover {
	background-color: #003d7a;
}
</style>
<body>
	<div class="container">
		<header class="text-center mb-6">
			<h1 class="title">Cảm ơn bạn đã đặt hàng!</h1>
		</header>
		<main class="main-content text-center">
			<h2>Đơn hàng của bạn đã được tiếp nhận.</h2>
			<p>Chúng tôi sẽ xử lý đơn hàng và gửi thông tin đến bạn trong
				thời gian sớm nhất.</p>
			<p>Thông tin đơn hàng:</p>
			<ul>
				<li>Họ và tên: <strong>${fullname}</strong></li>
				<li>Địa chỉ giao hàng: <strong>${shippingAddress}</strong></li>
				<li>Tổng giá trị: <strong>${totalPrice}</strong> VNĐ
				</li>
				<li>Phương thức thanh toán: <strong>${paymentMethod}</strong></li>
			</ul>
			<a href="${pageContext.request.contextPath}/books" class="btn">Quay
				lại trang sách</a>
		</main>
	</div>
</body>
</html>
