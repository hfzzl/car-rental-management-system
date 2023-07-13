<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>viewPayment</title>
<link th:href="@{/css/menubar.css}" rel="stylesheet">
<link th:href="@{/css/payment.css}" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="menu-bar">
	<div class="logo-menubar"><img src="images/logo.png" ></div>
	<div class="navigation">
		<table>
			<tr>
				<td class="nav-items"><a th:href="@{/home}">Home</a></td>
				<td>|</td>
				<td class="nav-items"><a th:href="@{/aboutus}">About Us</a></td>
				<td>|</td>
				<td class="nav-items"><a  th:href="@{/bookingCust}">Book A Car</a></td> 
				
			</tr>
		</table>
	</div>
	<div class="profile">
		<div class="nama-user"><span th:text="${session.username}"></span></div>
		<div class="profile-picture"><img src="images/profilepicture.png"></div>
		<div class="dropdown">
			<button class="dropdown-button"><i class="fa fa-caret-down"></i></button>
			<div class="dropdown-content">
				<a th:href="@{/profileCust}">Profile</a> 
				<a th:href="@{/logout}">Log Out</a>
			</div>
		</div>
	</div>
</div>

<div class="content-page-customer2">
	<div class="title3">
		<div class="title">Payment</div>
		<div>These are your payment history</div><br>
	</div>
	<div class="table">
		<table class="w3-table w3-striped w3-bordered">
			<tr>
				<th>Card Holder Name</th>
				<th>Email</th>
				<th>Card Number</th>
				<th>Expiration Month</th>
				<th>Expiration Year</th>
				<th>CVC</th>

			</tr>
			<tr th:each="payment : ${payment}">
				<td th:text="${payment.CHname}"></td>
				<td th:text="${payment.email}"></td>
				<td th:text="${payment.Cnum}"></td>
				<td th:text="${payment.ExpMonth}"></td>
				<td th:text="${payment.ExpYear}"></td>
				<td th:text="${payment.CVC}"></td>

			</tr>
		</table>
	</div>
</div>
</body>
</html>