<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RentoCar</title>
<link rel="stylesheet" type="text/css" th:href="@{/css/Registration.css}">
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>
	<div class="left-design">
		<div class="logo-picture"><img src="/images/logocar.png"/></div>
		<img src="/images/cars.png" class="cars-picture">
	</div>
<div class="right-design">
	<div class="sign-in-form">
		<h2>Sign Up</h2>
		<p>If you have an account,<br>You can <a href="login">Login here!</a></p><br>
		<form method="post" action="addCust">
			
			<div style="display: flex; flex-wrap: wrap; ">
				<div style="flex: 1; ">

			<label for="email" class="function"><strong>Email</strong></label><br>
			<input class="input-box" type="text" name="email" placeholder="Enter your email address"  required><br><br>

			<label for="username" class="function"><strong>username</strong></label><br>
			<input class="input-box" type="text" name="username" placeholder="Enter your username"  required><br><br>

			<label for="fullname" class="function"><strong>fullname</strong></label><br>
			<input class="input-box" type="text" name="fullname" placeholder="Enter your fullname"  required><br><br>

			<label for="birthdate" class="function"><strong>birthdate</strong></label><br>
			<input class="input-box" type="date" name="birthdate" placeholder="Enter your birthdate"  required><br><br>

			<label for="password" class="function"><strong>Password</strong></label><br>
			<input class="input-box" type="password" name="password" placeholder="Enter your password"  required><br><br>

            <label for="Re-typePassword" class="function"><strong>Re-type Password</strong></label><br>
			<input class="input-box" type="password" name="Re-typepassword" placeholder="Re-type your password"  required><br><br>

            <label for="phone_no" class="function"><strong>phone number</strong></label><br>
			<input class="input-box" type="text" name="phoneNo" placeholder="Enter your phone number"  required><br><br>
		</div>
		
			<div style="flex: 1; margin-left: 30px;">

            <label for="addressL1" class="function"><strong>address</strong></label><br>
			<input class="input-box" type="text" name="addressL1" placeholder="Unit No."  required>

            <label for="addressL2" class="function"><strong></strong></label><br>
			<input class="input-box" type="text" name="addressL2" placeholder="Street Name"required>

            <label for="addressL3" class="function"><strong></strong></label><br>
			<input class="input-box" type="text" name="addressL3" placeholder="Town Name" required><br><br>

            <label for="postcode" class="function"><strong>Postcode</strong></label><br>
			<input class="input-box" type="text" name="postcode" placeholder="Enter postcode"  required><br><br>

            <label for="city" class="function"><strong>city</strong></label><br>
			<input class="input-box" type="text" name="city" placeholder="Enter city"  required><br><br>

            <label for="state" class="function"><strong>state</strong></label><br>
			<input class="input-box" type="text" name="state" placeholder="Enter state"  required><br>
		</div>
			</div>
			<br>
			<button type="submit" value="signup" class="submit">Signup</button>
		</form>
	</div>
</div>
</body>
</html>