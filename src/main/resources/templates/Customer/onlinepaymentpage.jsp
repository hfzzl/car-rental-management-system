<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RentoCar</title>
<link th:href="@{/css/menubar.css}" rel="stylesheet">
<link th:href="@{/css/payment.css}" rel="stylesheet">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
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

<div class="content-page-customer">
	<div class="title">Payment Method</div>
	<div>Choose your payment method.</div><br>
	<table class="payment-options">
		<tr>
			<td>
				<button class="button"><img src="images/ewallet.png" style="width: 50px; height: 50px; padding-right:10px;">E-Wallet</button>
			</td>
		</tr>
		<tr>
			<td>
				<button class="button"><img src="images/Credit Card.png" style="width: 50px; height: 50px; padding-right:10px;">FPX</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>