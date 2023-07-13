<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RentoCar</title>
<link th:href="@{/css/menubar.css}" rel="stylesheet">
<link th:href="@{/css/home.css}" rel="stylesheet">
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
<div class="promotion">
	<img src="images/iriz.jpg">
	<img src="images/axia.jpg">
	<img src="images/myvi.jpg">
</div>
<div class="booknow">
	<form method="post" action="bookingCust">
		<input type="submit" value="Book Now!">
	</form>
</div>
<div class="feedback">
	<form method="post" action="newfeedback">
		<table>
			<tr><td><textarea id="feedback-box" name="feedback" placeholder="Please enter your feedback here.." rows="4" cols="100" required></textarea></td></tr>
			<tr><td align="right"><input id="feedback-button" type="submit" value="Send Feedback" name="feedback"></td></tr>
		</table>
	</form>
</div>
</body>
</html>