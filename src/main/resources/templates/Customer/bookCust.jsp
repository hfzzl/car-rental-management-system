<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RentoCar</title>
<link th:href="@{/css/menubar.css}" rel="stylesheet">
<link th:href="@{/css/sidebar.css}" rel="stylesheet">
<link th:href="@{/css/bookingForm.css}" rel="stylesheet">

<link rel="stylesheet" th:href="@{css/bootstrap.min.css}">
<link href="https://cdn.bootcdn.net/ajax/libs/highlight.js/11.0.1/styles/default.min.css" rel="stylesheet">
<link rel="stylesheet" th:href="@{css/boxed-check.css}">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">

<script type="text/javascript">
    function GetDays(){
            var pickdt = new Date(document.getElementById("pDate").value);
            var returnkdt = new Date(document.getElementById("rDate").value);
            return parseInt((returnkdt - pickdt) / (3600 * 1000));
    }

    function cal(){
    if(document.getElementById("rDate")){
        document.getElementById("numdays2").value=GetDays();
    }  
    }

    function cal2() {
  const getSeconds = s => s.split(":").reduce((acc, curr) => acc * 60 + +curr, 0);
  var seconds1 = getSeconds(document.getElementById("pTime").value);
  var seconds2 = getSeconds(document.getElementById("rTime").value);

  var res = Math.abs(seconds2 - seconds1);

  var hours = Math.floor(res % 3600 / 60);

  var newHours ;

  if(seconds2<seconds1){
    const timeDifference =  document.getElementById('timeDifference');
    newHours = GetDays()- hours;
    timeDifference.value=newHours;
  }

  else{
    const timeDifference =  document.getElementById('timeDifference');
    newHours = GetDays()+ hours;
    timeDifference.value=newHours;
  }
  var minutes = res % 60;
  document.getElementById("timeDifference").innerHTML = newHours;
//   document.getElementById("timeDifference").innerHTML = hours + "." + minutes;
}

</script><script type="text/javascript">
    function GetDays(){
            var pickdt = new Date(document.getElementById("pDate").value);
            var returnkdt = new Date(document.getElementById("rDate").value);
            return parseInt((returnkdt - pickdt) / (3600 * 1000));
    }

    function cal(){
    if(document.getElementById("rDate")){
        document.getElementById("numdays2").value=GetDays();
    }  
    }

    function cal2() {
  const getSeconds = s => s.split(":").reduce((acc, curr) => acc * 60 + +curr, 0);
  var seconds1 = getSeconds(document.getElementById("pTime").value);
  var seconds2 = getSeconds(document.getElementById("rTime").value);

  var res = Math.abs(seconds2 - seconds1);

  var hours = Math.floor(res % 3600 / 60);

  var newHours ;

  if(seconds2<seconds1){
    const timeDifference =  document.getElementById('timeDifference');
    newHours = GetDays()- hours;
    timeDifference.value=newHours;
  }

  else{
    const timeDifference =  document.getElementById('timeDifference');
    newHours = GetDays()+ hours;
    timeDifference.value=newHours;
  }
  var minutes = res % 60;
  document.getElementById("timeDifference").innerHTML = newHours;
//   document.getElementById("timeDifference").innerHTML = hours + "." + minutes;
}

</script>
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
<div class="content2">
    <div class="title2">Booking Form</div>
        <form class="bookingForm" method="post" action="addBookingCustomer">
            <div class="leftSide">
                <div class="leftContent">
                    <table class="leftTable">
                        <tr>
                            <th class="left" colspan="2">
                                Name :
                            </th>
                        </tr>

                        <tr>
                            <td class="left" colspan="2"><input type="text" name="fullname" th:value="${detailC[0].fullname}" readonly></td>
                        </tr>

                        <tr>
                            <th class="left" colspan="2">Phone Number :</th>
                        </tr>

                        <tr>
                            <td class="left" colspan="2"><input type="text" name="phoneNo" th:value="${detailC[0].phone_no}" readonly></td>
                        </tr>

                        <tr>
                            <th class="left" colspan="2">Email address :</th>
                        </tr>

                        <tr>
                            <td class="left" colspan="2"><input type="text" name="email" th:value="${detailC[0].email}" readonly></td>
                        </tr>

                        <tr></tr>
                        <tr><th style="padding-left: 15px;">Pickup Details</th><th>Return Details</th></tr>

                        <tr>
                            <td class="left" style="padding-left: 15px;">
                                Pickup Date :
                            </td>
                            <td class="left">
                                Return Date :
                            </td>
                        </tr>

                        <tr>
                            <td class="left" style="padding-left: 15px;">
                                <input type="date" id="pDate" name="pDate"  onchange="cal()" required>
                            </td>
                            <td class="left">
                                <input type="date" id="rDate" name="rDate"  onchange="cal()" required>
                            </td>
                        </tr>

                        <tr>
                            <td class="left" style="padding-left: 15px;">
                                Pickup Time :
                            </td>
                            <td class="left">
                                Return Time :
                            </td>
                        </tr>

                        <tr>
                            <td class="left"style="padding-left: 15px;">
                                <input type="time" id="pTime" name="pTime"  onchange="cal2()"required>
                            </td>
                            <td class="left">
                                <input type="time" id="rTime" name="rTime"  onchange="cal2()" required>
                            </td>
                        </tr>
                        <!-- <tr>
                                <div id="numdays"><label class="form">Number of days:</label> -->
                                    <input type="hidden" class="textbox" id="numdays2" name="numdays"/>
                                <!-- </div>
                            </tr>
                            <tr>
                                <b>Total Hours: </b> -->
                                <!-- <p id="timeDifference"></p> -->
                                <input type="hidden" id="timeDifference" name="timeDifference" >
                            <!-- </tr> -->
                            <tr>
                                <td><input type="hidden" name="pStatus" value="N/A" ></td>
                            </tr>
                            <tr>
                                <td><input type="hidden" name="rStatus" value="N/A" ></td>
                            </tr>
                        </table>
                </div>
            </div>
            <div class="rightSide">
                <div class="leftContent">
                    <b>Available Vehicle</b>
                    <table class="my-table w3-table w3-striped w3-bordered">
                        <tr th:each="vehicle : ${vehicle}">
                            <div class="boxed-check-group boxed-check-success">
                                <label class="boxed-check">
                                <input class="boxed-check-input" type="radio" name="radio-overview-custom" th:value="${vehicle.vehicleid}" required>
                                <div class="boxed-check-label" style="text-align:left;">
                                    <b th:text="${vehicle.brand}" >title</b> 
                                    <b th:text="${vehicle.model}" >Subtitle</b>
                                    <br><p th:remove="tag">Color :</p>
                                    <small th:text="${vehicle.colour}" th:remove="tag" >Subtitle</small>
                                    <br><p th:remove="tag">Reg No :</p>
                                    <small th:text="${vehicle.registrationno}" th:remove="tag" >Subtitle</small>
                                    <br><p th:remove="tag">Rate/hour : RM</p>
                                    <small th:text="${vehicle.rate}" th:remove="tag" >Subtitle</small>
                                    <small th:text="${vehicle.vehicleid}" >Subtitle</small>
                                </div>
                                </label>
                            </div>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="submitBttn">
                <div class="submitBttnContent">
                    <input type="submit" class="submitButton" value="submit">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>