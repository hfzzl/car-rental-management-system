
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
<link th:href="@{/css/menubar.css}" rel="stylesheet">
<link th:href="@{/css/ProfileStyle.css}" rel="stylesheet">
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
<div class=content>
    <div class="container">
<div class=leftbox>
	<div class=profile2>
		<div class=profileContent>
		<form action="updateProfile.html" method="get">
            <table class="profileTab"  width ="100%">
		
                <tr>
                <td style="text-align: center" colspan="3">
                <img src="images/profileImage.png" width="200" height="200" alt="profileImage" />
                </td>
                </tr>
                
                <tr>
                <td colspan="3">
                <h3>My Profile</h3>
                </td>
                </tr>
                
                <tr>
                    <td colspan="2" width ="70%">
                    <p th:text="${detailC[0].fullname}"></p>
                    </td>
                    <td colspan="1" width ="20%">
                    <p th:text="${detailC[0].birthdate}"></p>
                    </td>
                    </tr>
                    
                    <tr>
                        <td width ="10%">+60</td>
                    <td  colspan="3">
                    <p th:text="${detailC[0].phone_no}"></p>
                    </td>
                    </tr>
                    
                    <tr>
                    <td colspan="3">
                    <p th:text="${detailC[0].email}"></p>
                    </td>
                    </tr>
                
                <tr>
                <td colspan="3" style="text-align: center">
            
                </td>
                </tr>
                
                </table>
		</form>
		
		</div>
		
		
		</div>
	</div>
	
	<div class=rightbox> 
        <div class="rightboxcontent">
	        <div class= address>
                <div class="line"></div>
		            <div class=addressContent>
			
			            <form action="updateAddressCust" method="post">
				            <table class="addressTab"  width=100% >
				                <tr>
                                <td colspan="2" width ="90%">
                                <h3>My address</h3>
                                </td>
                                <td colspan="1" align= "right">
                                <input class="button" type="submit" value="Save">
                                </td>
                                </tr>
                            
                                <tr>
                                <td colspan="3" style="padding: 15px 15px 15px 0px">
                                    <input type="text" id="addressL1" name="addressL1" placeholder="Address Line 1" th:value="${detailC[0].addressL1}" required>
                                </td>
                                </tr>
                                
                                <tr>
                                <td colspan="3" style="padding: 15px 15px 15px 0px">
                                    <input type="text" id="addressL2" name="addressL2" placeholder="Address Line 2" th:value="${detailC[0].addressL2}" required>
                                </td>
                                </tr>
                                
                                <tr>
                                <td colspan="3" style="padding: 15px 15px 15px 0px">
                                    <input type="text" id="addressL3" name="addressL3" placeholder="Address Line 3" th:value="${detailC[0].addressL3}" required>
                                </td>
                                </tr>
                                
                                <tr>
                                <td colspan="1" width=25% style="padding: 15px 15px 15px 0px">
                                    <input type="text" id="postcode" name="postcode" placeholder="Postcode" th:value="${detailC[0].postcode}" required>
                                </td>
                                <td colspan="1" width=40% style="padding: 15px 15px 15px 0px">
                                    <input type="text" id="city" name="city" placeholder="City" th:value="${detailC[0].city}" required>
                                </td>
                                <td colspan="1" width=33% style="padding: 15px 15px 15px 0px">
                                    <input type="text" id="state" name="state" placeholder="State" th:value="${detailC[0].state}" required>
                                </td>
                                </tr>
                            </table>			
			
			            </form>
		            </div>
	        </div>
	
	        <div class=payment>
                <div class="line"></div>
		        <div class=paymentContent >
			        <form action="" method="get">
                        <table class="paymentTab"  width=100%>
                            <tr>
                            <td colspan="2" width=90%>
                            <h3>Saved Payment</h3>
                            </td>
                            <td colspan="1" align="right">
                            
                            </td>
                            </tr>
                            
                            <tr>
                                <td width=50% style="padding: 15px 15px 15px 0px" align="center">
                                    <img src="images/Visa_Logo.png" class="visa">
                            </td>
                            <td colspan="2" style="padding: 15px 15px 15px 0px">
                                <b>4533 **** **** 1223</b>
                            </td>
                            </tr>
                        </table>
			
			        </form>
		        </div>
	        </div>
	    </div>
    </div>
</div>
</div>
</body>
</html>