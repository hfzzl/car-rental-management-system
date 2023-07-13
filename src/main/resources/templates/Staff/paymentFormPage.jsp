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
	<div class="content2">
		<!-- <div class="purchase-log">
			<div class="purchase-log-content">
				<h2>Your Purchase</h2>
			</div>
		</div> -->
		<div class="form">
			<div class="title2">Payment Details</div>
			<div>Choose your payment method.</div><br>

			<form method="post" action="addPayment" >
				<label for="cname">Cardholder Name</label><br> 
				<input type="text" name="CHname" placeholder="Insert the cardholder name.." required><br>
				<br>
				<label for="email">Email</label><br> 
				<input type="text" name="email" placeholder="example@example.com" required><br>
				<br>
				<label for="cnum">Card Number</label><br> 
				<input type="text" name="Cnum" placeholder="12345 12345 12345 12345" required><br>
				<br>

				<div>Card Expiration</div>
				<table>
					<tr>
						<td>
							<label for="expMonth">Month</label><br> 
							<select	class ="select" name="ExpMonth">
								<option value="Jan">January</option>
								<option value="Feb">February</option>
								<option value="March">March</option>
								<option value="Apr">April</option>
								<option value="May">May</option>
								<option value="Jun">June</option>
								<option value="July">July</option>
								<option value="Aug">August</option>
								<option value="Sep">September</option>
								<option value="Oct">October</option>
								<option value="Dec">December</option>
							</select> 
						</td>
						<td>
							<label for="expYear">Year</label><br> 
							<select class ="select" name="ExpYear">
								<option value="2022">2022</option>
								<option value="2023">2023</option>
								<option value="2024">2024</option>
								<option value="2025">2025</option>
								<option value="2026">2026</option>
								<option value="2027">2027</option>
								<option value="2028">2028</option>
								<option value="2029">2029</option>
								<option value="2030">2030</option>
								<option value="2031">2031</option>
								<option value="2032">2032</option>
							</select>
						</td>
					</tr>
				</table>
				<br> 
				<label for="cvc">CVC</label><br> 
				<input type="text" name="CVC" placeholder="No. at the back of the card.."><br>
				<br>
				<button class="button5" onclick="myFunction()">PAY NOW</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>

<script>
	function myFunction() {
		alert("Your payment is successful");
	}
</script>