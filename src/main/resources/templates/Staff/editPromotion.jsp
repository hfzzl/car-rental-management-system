<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RentoCar</title>
<link th:href="@{/css/menubar.css}" rel="stylesheet">
<link th:href="@{/css/sidebar.css}" rel="stylesheet">
<link th:href="@{/css/managePromotion.css}" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
				<td class="nav-items"><a th:href="@{/booking}">Book A Car</a></td> 
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
	<!-- ---------------------------------------------------------------------------------- -->
	<div class="content">
		<div class="title">Edit Promotion</div>
		<div>Click on the appropiate action buttons.</div><br>
		
		<div class="edit-button">
			<form method="post" action="viewAllPromotion">
				<input type="submit" class="form-button2 fas fa-chevron-left" value="&#xf053; Back">
			</form>
			<form method="post" action="viewAddPromotion">
				<input type="submit" class="form-button2 fas fa-plus-circle" value="&#xf055; Add">
			</form>
		</div><br>
		<div class="table">
			<table class="my-table w3-table w3-striped w3-bordered">
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Percentage</th>
					<th>Actions</th>
				</tr>
				<tr th:each="promotion : ${promotion}">
					<td th:text="${promotion.name}"></td>
					<td th:text="${promotion.description}"></td>
					<td th:text="${promotion.percentage}"></td>
					<td>
						<div class="columnbttn">
							<form class="formbttn" method="post" action="viewUpdatePromotion">
								<input type="hidden" name="promotionid" th:value="${promotion.promotionid}">
								<input type="submit" class="form-button fa fa-edit" value="&#xf044;" >
							</form>
							<form class="formbttn" method="post" action="deletePromotion">
								<input type="hidden" name="promotionid" th:value="${promotion.promotionid}">
								<input type="submit" class="form-button fas fa-trash-alt" value="&#xf2ed;">
							</form>

						</div>
						
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
</body>
</html>