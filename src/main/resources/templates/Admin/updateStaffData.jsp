<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RentoCar</title>
<link th:href="@{/css/menubar.css}" rel="stylesheet">
<link th:href="@{/css/sidebar.css}" rel="stylesheet">
<link th:href="@{/css/manageStaff.css}" rel="stylesheet">
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
			</tr>
		</table>
	</div>
	<div class="profile">
		<div class="nama-user"><span th:text="${session.username}"></span></div>
		<div class="profile-picture"><img src="images/profilepicture.png"></div>
		<div class="dropdown">
			<button class="dropdown-button"><i class="fa fa-caret-down"></i></button>
			<div class="dropdown-content">
				<a th:href="@{/profileAdmin}">Profile</a> 
				<a th:href="@{/logout}">Log Out</a>
			</div>
		</div>
	</div>
</div>
<div class="content-container">
	<div class="menu-sidebar">
		<div class="head">Admin Function</div>
		<div class="header">Vehicle</div>
		<div class="nav-items2"><a th:href="@{/managevehicle}">Manage Vehicle</a></div> 
		<div class="nav-items2"><a th:href="@{/vehiclecondition}">Vehicle Condition</a></div> 
		
		<div class="header">Staff</div>
		<div class="nav-items2" id="boxAdmin"><a th:href="@{/viewAllAdmin}">Manage Admin</a></div>
		<div class="nav-items2" ><a th:href="@{/viewAllStaff}">Manage Staff</a></div>

		<div class="header">Report</div>
		<div class="nav-items2"><a th:href="@{/getreport}">View Report</a></div> 
		<div class="nav-items2"><a th:href="@{/viewAllFeedback}">View Feedback</a></div> 
	</div>
	<div class="content">
		<div class="title">Update Staff</div>
		<div>Update the staff details and then click save.</div><br>
		
		<div class="edit-button">
			<form method="post" action="viewEditStaff">
				<input type="submit" class="form-button2 fas fa-chevron-left" value="&#xf053; Back">
			</form>
		</div><br>
		<div class="tableAdd">
			<form method="post" action="updateStaff">
				<table>
					
					<tr>
						<th>Fullname : </th>
						<td><input type="text" name="fullname" th:value="${staff[0].fullname}" style="width: 100%;"required></td>
					</tr>
					<tr>
						<th>Phone No. : </th>
						<td><input type="text" name="phone_no" th:value="${staff[0].phone_no}" style="width: 100%;"required></td>
					</tr>
					<tr>
						<th>Email : </th>
						<td><input type="text" name="email" th:value="${staff[0].email}" style="width: 100%;"required></td>
					</tr>
					<tr>
						<th>Address Line 1 : </th>
						<td><input type="text" name="addressL1" th:value="${staff[0].addressL1}" style="width: 100%;"required></td>
					</tr>
					<tr>
						<th>Address Line 2 : </th>
						<td><input type="text" name="addressL2" th:value="${staff[0].addressL2}" style="width: 100%;"required></td>
					</tr>
                    <tr>
						<th>Address Line 3 : </th>
						<td><input type="text" name="addressL3" th:value="${staff[0].addressL3}" style="width: 100%;"required></td>
					</tr>
                    <tr>
						<th>Postcode : </th>
						<td><input type="text" name="postcode" th:value="${staff[0].postcode}" style="width: 100%;"required></td>
					</tr>
                    <tr>
						<th>City : </th>
						<td><input type="text" name="city" th:value="${staff[0].city}" style="width: 100%;"required></td>
					</tr>
                    <tr>
						<th>State : </th>
						<td><input type="text" name="state" th:value="${staff[0].state}" style="width: 100%;"required></td>
					</tr>
					<tr>
						<td><input type="hidden" name="userid" th:value="${staff[0].userid}"></td>
					</tr>
					<tr>
						<td colspan="3" align="center"><input type="submit" class="form-button2 fa fa-floppy-o" value="&#xf0c7; Save"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
</body>
</html>