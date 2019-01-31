<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
	font-weight: 800;

   
}

li a:hover:not(.active) {
   	opacity: 0.2;
}
.button5:hover:not(.active)
{
opacity: 0.2;
}
.button1:hover:not(.active),.button2:hover:not(.active),.button3:hover:not(.active),.button4:hover:not(.active)
{
width:150px;
font-size: 12px;

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
	color: white;
    text-align: left;
    padding: 18px 20px;
    text-decoration:none;
    font-family: "ETmodules";
	font-weight: 800;
	border: none;
	
}
.image-1 { 
	position: absolute;
    left: 0px;
    top: 0px;
    z-index: -1;
    width: 100%;
    height: 550px;
    opacity: 0.2;
    z-index: -1;
}

.para
{font-family: "ETmodules";
   	font-size: 25px;
	font-weight: 800;
	color: white;
}

.home
{
	float:left;
	font-size: 15px;

}
.aa{
position:fixed;
left:50px;
width:520px;
height:370px;
background-color:rgba(0,0,0,0.5);
margin-top:40px;
padding-top: 10px;
border-radius:15px;
-webkit-border-radius:15px;
-o-border-radius:15px;
-moz-border-radius:15px;
color:white;
font-weight:bolder;
box-shadow: inset -4px -4px rgba(0,0,0,0.5);
font-size:18px;
}

.con
{
padding-left:60px;}

.button1,.button2,.button3,.button4
{
background-color: #007DB8;
border-radius: 12px;
width:200px;
font-size: 18px;
}
.button5
{
background-color:rgba(0,0,0,0);
font-size: 26px;

}

.mySlides {display:none;}

</style>
</head>
<body>
<br><br><br>



	<img class="image-1" src="pic3.jpg">
  	<ul>
  		<li class="home"><a href="home.jsp"><i class="fa fa-home"></i>HOME</a>
  		<li class="name1"><img src="http://i.dell.com/images/global/brand/ui/logo-wt-bl.png" width="49"  height="49" alt="Dell" title="Dell" border="0"></li>
		<li class="name">AMS Health Check Portal</li>
	</ul>
 

<p>

<div class="w3-content w3-content" style="max-width:25px">
  <img class="mySlides" src="pic3.jpg" style="float:right; position:fixed; top:60px;">
  <img class="mySlides" src="pic1.jpg" style="float:right; position:fixed;top:60px;">
  <img class="mySlides" src="pic3.jpg" style="float:right; position:fixed; top:60px;">
</div>
<div class="aa">
<div class="para"><form action = validateHCLogin method="post">
			<input class="button button5" type="submit" name="HEALTH CHECKUP" value="HEALTH CHECKUP>>">
			</form></div><br>
<div align="left" class="con">

<button class = "button button1"><img width="16" height="16" src="x1.PNG">Window Services</button>&nbsp;
<button class = "button button4">&#9755; Web Services</button><br><br>
<button class = "button button2">&#9755; Middle Ware</button>&nbsp;
<button class = "button button3">&#9755; URL</button><br><br>
<button class = "button button3">&#9755; DB Servers</button>&nbsp;
<button class = "button button3">&#9755; FTP/SFTP</button>

</div>

</center> 
</div>
</p>
<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>





</body>
</html>