<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HealthCheckup Login Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">s
<script type="text/javascript" src="progress.js"></script>
<style>
body{
background-image: url("pic1.jpg");
background-size:cover;
margin:0;}


ul {
	overflow: hidden;
  	position:relative;
    list-style-type: none;
    margin: 0;
    padding: 0;
    background-color: #007DB8;
    position: fixed;
    top: 0;
    left:0;
    width: 100%;
    font-family: "ETmodules";

}

li {
    float: right;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration:none;
    font-family: "ETmodules";
   	font-size: 18px;
	font-weight: 800;
}

li a:hover:not(.active) {
   	opacity: 0.2;
}
.button:hover:not(.active)
{
opacity: 0.2;
}
.name
{
	display: block;
    color: white;
    text-align: center;
    padding: 8px 10px;
    font-family: "ETmodules";
   	font-size: 25px;
	font-weight: 800;
	position:fixed;
	left:500px;
    
}
.name1
{
position:fixed;
	left:460px;
}
.button
{
	background-color: #007DB8;
	color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration:none;
    font-family: "ETmodules";
	font-weight: 800;
	border: none;
	
}

.loader {
  border: 4px solid #f3f3f3;
  border-radius: 50%;
  border-top: 4px solid #3498db;
  width:  30px;
  height: 30px;
  -webkit-animation: spin 2s linear infinite; /* Safari */
  animation: spin 2s linear infinite;
}

/* Safari */
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

.aa{
width:380px;
height:370px;
background-color:rgba(0,0,0,0.5);
margin:0 auto;
margin-top:40px;
padding-top: 10px;
padding-left:0px;
border-radius:15px;
-webkit-border-radius:15px;
-o-border-radius:15px;
-moz-border-radius:15px;
color:white;
font-weight:bolder;
box-shadow: inset -4px -4px rgba(0,0,0,0.5);
font-size:18px;
}

.aa input[type="text"]{
width:200px;
height:35px;
border:0;
border-radius:5px;
-webkit-border-radius:5px;
-o-border-radius:5px;
-moz-border-radius:5px;
padding-left:5px;
}

.aa input[type="password"]{
width:200px;
height:35px;
border:0;
padding-left:5px;
border-radius:5px;
-webkit-border-radius:5px;
-o-border-radius:5px;
-moz-border-radius:5px;

}

.selector{
width:200px;
height:35px;
padding-left:5px;
border:0;
border-radius:5px;
-webkit-border-radius:5px;
-o-border-radius:5px;
-moz-border-radius:5px;

}

.aa input[type="submit"]{
  border: 2px solid black;
  border-radius: 5px;
  background-color: white;
  color: black;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
  border-color: #007DB8;
  color: #007DB8;
}

.aa input[type="submit"]:hover
{
background-color: #007DB8;
  color: white;
}

.home
{
	float:left;
	font-size: 15px;

}


</style>
</head>
<body>
<ul>
  		<li class="home"><a href="home.jsp"><i class="fa fa-home"></i>HOME</a>
  		<li class="name1"><img src="http://i.dell.com/images/global/brand/ui/logo-wt-bl.png" width="49"  height="49" alt="Dell" title="Dell" border="0"></li>
		<li class="name">AMS Health Check Portal</li>
	</ul>
<br><br><br><br>
<%
String login_msg=(String)request.getAttribute("error");  
if(login_msg!=null)
out.println("<font color=black size=5px>"+login_msg+"</font>");
 %>

 <center>

<form action = HealthReport method="post" name="myform">
<div class="aa">
<h3>Enter ADM Account Credentials</h3><br>
<select class="selector" name="dom">
<option class=>Please Select Domain</option>
<option value="Americas">Americas</option>
<option value="Europe">Europe</option>
<option value="Asia-Pacific">Asia-Pacific</option>
</select><br><br>
<input type="text" name = "user" placeholder="Please Enter Username....." required=""><br><br>
<input type="password" placeholder="Please Enter Password....." name= "pass" required=""><br><br>
<br>
<div id="logincontent" >
<input class="target" id = "target" type="submit" name = "Submit" value = "Submit" onclick="progress()">
</div>
<br><br>
</div>
<br><br>
<div id=loader style="visibility:hidden;" class="loader">
</form>
</div>
</center>





</body>
</html>