<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>RentoCar</title>
<link th:href="@{/css/login.css}" rel="stylesheet" />

<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet" />
</head>
<body>
<div class="left-design">
	<div class="logo-picture"><img src="/images/logocar.png"/></div>
	<img src="/images/cars.png" class="cars-picture">
</div>
<div class="right-design">
	<div class="sign-in-form">
		<h3>Sign In</h3>
		<p>If you don't have an account,<br>You can <a th:href="@{register}">Register here!</a></p>
		<form method="post" action="index">
			<span th:if="${errorMessage}" th:text="${errorMessage}" class="errorMessage"></span><br><br>
			<label for="email" class="function"><strong>Choose: </strong></label><br>
			<select name="usertype" class="custom-select">
				<option value="customer">Customer</option>
				<option value="staff">Staff</option>
				<option value="admin">Admin</option>
			</select>
			<br>
			<label for="email" class="function"><strong>Username</strong></label><br>
			<input class="input-box" type="text" name="username" placeholder="Enter your username"  required><br><br>
			<label for="password" class="function"><strong>Password</strong></label><br>
			<input class="input-box" type="password" name="password" placeholder="Enter your password"  required><br><br>
			
			<div class="function-space">
				<div>
					<input type="checkbox" name="remember">
					<label for="remember" class="function">Remember me</label>
				</div>
					<a href="forgotPassword.jsp" class="function">Forgot Password</a>
			</div>
			<br>
			<br>
			<button class="login-button" type="submit">Login</button>
		</form>
	</div>
</div>
</body>
</html>

<script>
class CustomSelect {
	constructor(originalSelect) {
		this.originalSelect = originalSelect;
		this.customSelect = document.createElement("div");
		this.customSelect.classList.add("select");

		this.originalSelect.querySelectorAll("option").forEach((optionElement) => {
			const itemElement = document.createElement("div");

			itemElement.classList.add("select__item");
			itemElement.textContent = optionElement.textContent;
			this.customSelect.appendChild(itemElement);

			if (optionElement.selected) {
				this._select(itemElement);
			}

			itemElement.addEventListener("click", () => {
				if (this.originalSelect.multiple && itemElement.classList.contains("select__item--selected")) {
					this._deselect(itemElement);
				} 
				else {
					this._select(itemElement);
				}
			});
		});

		this.originalSelect.insertAdjacentElement("afterend", this.customSelect);
		this.originalSelect.style.display = "none";
	}

	_select(itemElement) {
		const index = Array.from(this.customSelect.children).indexOf(itemElement);

		if (!this.originalSelect.multiple) {
			this.customSelect.querySelectorAll(".select__item").forEach((el) => {
				el.classList.remove("select__item--selected");
			});
		}

		this.originalSelect.querySelectorAll("option")[index].selected = true;
		itemElement.classList.add("select__item--selected");
	}

	_deselect(itemElement) {
		const index = Array.from(this.customSelect.children).indexOf(itemElement);

		this.originalSelect.querySelectorAll("option")[index].selected = false;
		itemElement.classList.remove("select__item--selected");
	}
}

document.querySelectorAll(".custom-select").forEach((selectElement) => {
	new CustomSelect(selectElement);
});
</script>