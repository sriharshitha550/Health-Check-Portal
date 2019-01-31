<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>High Critical Page</title>
<style>
body{
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
	float:left;
	display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    font-family: "ETmodules";
   	font-size: 25px;
	font-weight: 800;
    
}
.button
{
	background-color: #007DB8;
	color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration:none;
    font-family: "ETmodules";
   	font-size: 18px;
	font-weight: 800;
	border: none;
	
}


</style>
</head>
<body>
<ul>
		<li class="name">AMS Portal</li>
		<li><a href="highCritical.jsp">High/Critical Update</a></li>
   		<li><form action = validateHCLogin method="post">
			<input class="button" type="submit" name="Health Checkup" value="Health Checkup">
			</form></li>
   		<li><a href="home.jsp">Home</a>
   	</ul>
<br><br><br>
High Critical Update Page
</body>
</html>