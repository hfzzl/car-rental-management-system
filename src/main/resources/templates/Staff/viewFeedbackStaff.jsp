<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RentoCar</title>
<link th:href="@{/css/menubar.css}" rel="stylesheet">
<link th:href="@{/css/sidebar.css}" rel="stylesheet">
<link th:href="@{/css/feedback.css}" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins&display=swap">
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
				<td class="nav-items"><a  th:href="@{/booking}">Book A Car</a></td>
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
		<div class="title">Feedback</div>
		<div>These feedbacks are provided by users, staff, and admins.</div><br>
		<div class="table">
			<table class="w3-table w3-striped w3-bordered">
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Feedback</th>
				</tr>
				<tr th:each="feedback : ${feedback}">
					<td class="name" th:text="${feedback.fullname}"></td>
					<td class="date" th:text="${feedback.date}"></td>
					<td class="feedback" th:text="${feedback.feedback}"></td>
				</tr>
			</table>
		</div>
	</div>
</div>
</body>
</html>