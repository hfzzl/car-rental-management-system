<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RentoCar</title>
<link th:href="@{/css/menubar.css}" rel="stylesheet">
<link th:href="@{/css/sidebar.css}" rel="stylesheet">
<link th:href="@{/css/payment.css}" rel="stylesheet">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>
<div class="menu-bar">
	<div class="logo-menubar">
		<img src="images/logo.png">
	</div>
	<div class="navigation">
		<table>
			<tr>
				<td class="nav-items"><a href="feedback.jsp">Home</a></td>
				<td>|</td>
				<td class="nav-items"><a href="aboutus.jsp">About Us</a></td>
				<td>|</td>
				<td class="nav-items"><a href="booking.jsp">Book A Car</a></td>
			</tr>
		</table>
	</div>
	<div class="profile">
		<div class="nama-user"><span th:text="${session.username}"></span></div>
		<div class="profile-picture"><img src="images/profilepicture.png"></div>
		<div class="dropdown">
			<button class="dropdown-button"><i class="fa fa-caret-down"></i></button>
			<div class="dropdown-content">
				<a th:href="@{/profileStaff}">Profile</a> 
				<a th:href="@{/logout}">Log Out</a>
			</div>
		</div>
	</div>
</div>
<div class="content-container">
	<div class="menu-sidebar">
		<div class="head">Staff Function</div>
		<div class="header">Database</div> 
		<div class="nav-items2"><a th:href="@{/vehiclecondition}">Vehicle Condition</a></div> 
		<div class="nav-items2"><a th:href="@{/viewAllPromotion}">Manage Promotion</a></div> 
		<div class="nav-items2"><a th:href="@{/viewAllBooking}">Manage Booking</a></div>
		
		<div class="header">Report</div>
		<div class="nav-items2"><a th:href="@{/getreport}">View Report</a></div> 
		<div class="nav-items2"><a th:href="@{/viewAllFeedback}">View Feedback</a></div> 
	</div>
	<div class="content">
		<div class="title">Payment Method</div>
		<div>Choose your payment method.</div><br>
		<h1>Total price to be paid : </h1>
		<table>
			<tr>
				<td>
					<h1 >RM</h1>
				</td>
				<td>
					<h1 th:text="${session.price}" ></h1>
				</td>
			</tr>
		</table>
		
		
		<table class="payment-options">
			<tr>
				<td>
					<form action="viewpaymentFormPage" method="post">
						<button class="button"><img src="images/Credit Card.png"style="width: 50px;height: 50px; padding-right:10px;">Credit Card</button>
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<form action="viewpaymentFormPage" method="post">
						<button class="button"><img src="images/debit card.png"style="width: 50px;height: 50px; padding-right:10px;">Debit Card</button>
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<form action="viewonlinePaymentPage" method="post">
						<button class="button"><img src="images/Online Payment.png"style="width: 50px;height: 50px; padding-right:10px;">Online Payment</button>
					</form>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>