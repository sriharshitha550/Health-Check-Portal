<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Health Checkup Report</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<SCRIPT LANGUAGE="JavaScript">
<!-- 

<!--
function Check(chk)
{
if(document.myform.Check_ctr.checked==true){
for (i = 0; i < chk.length; i++)
chk[i].checked = true ;
}else{

for (i = 0; i < chk.length; i++)
chk[i].checked = false ;
}
}

// End -->
</script>
<script type="text/javascript" src="progress.js"></script>
<script type="text/javascript" src="tes.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<style>
body{
margin:0;
background-image: url("img5.jpg"), url("img4.jpg");
width: 100%;}


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
.button5:hover:not(.active){
	background-color: #42AEAF;
	color: white;
    text-align: center;
    padding: 22px 24px;
    text-decoration:none;
    font-family: "ETmodules";
   	font-size: 30px;
	font-weight: 800;
	border: none;
	width:45%
}
.subbtn:hover:not(.active)
{

border: 2px solid black;
  border-radius: 5px;
  background-color: white;
  color: black;
  padding: 10px 24px;
  font-size: 14px;
  cursor: pointer;
  border-color: #007DB8;
  color: #007DB8;

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
.button,.inv
{
	
	color: white;
    padding: 14px 16px;
    text-decoration:none;
    font-family: "ETmodules";
   	font-size: 18px;
	font-weight: 800;
	border: none;
	
}
.button5
{
text-align: center;
background-color: #42AEAF;
border-radius: 12px;
width:40%
}

.check1
{
	border: 2px solid black;
  border-radius: 5px;
  background-color: white;
  color: black;
  padding: 12px 26px;
  font-size: 16px;
  cursor: pointer;
  border-color: #42AEAF;
  color: #42AEAF;

}

.subbtn
{
border: 2px solid black;
  border-radius: 5px;
  background-color: #007DB8;
  color: black;
  padding: 12px 26px;
  font-size: 16px;
  cursor: pointer;
  border-color: white;
  color: white;
}
.home
{
	float:left;
	font-size: 15px;

}

.name1
{
position:fixed;
	left:460px;
}

.inv {
background-color:rgba(0,0,0,0);
    display: none;
    border-radius: 12px;
	width:40%
}
.vis
{
display:"block";

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
</style>

</head>
<body>
<ul>
		<ul>
  		<li class="home"><a href="home.jsp"><i class="fa fa-home"></i>HOME</a>
  		<li class="name1"><img src="http://i.dell.com/images/global/brand/ui/logo-wt-bl.png" width="49"  height="49" alt="Dell" title="Dell" border="0"></li>
		<li class="name">AMS Health Portal</li>
	</ul>
   	</ul>
<br><br><br><br>

<%-- <%
 
if(session!=null){  
String usernm =(String)session.getAttribute("username");
out.println(usernm);
String pas = (String)session.getAttribute("password");
}
%> --%>
<form name="myform" action=LoginDirectpage method="post">
<div id="target">
<%String sdomcount=(String)request.getAttribute("domncount");
int domcount = Integer.parseInt(sdomcount);
String dname="domname";
String aname = "applname";
int j=0;
for(int temp=0;temp<domcount;temp++)
{
	j++;
	String dname2 = dname + Integer.toString(j);
	String dum = "x"+(String)request.getAttribute(dname2);
%>
<center><input type="button" class="button button5" value="<%=(String)request.getAttribute(dname2)%>"></center>
<center><div id=<%=(String)request.getAttribute(dname2)%> class=inv>
<h1><%=(String)request.getAttribute(dname2)%> APPLICATIONS</h1>
<table>
<tr><td><input type="checkbox" name="Check_ctr" value=dum class="checkallbtn"><b>Check All</b> </td></tr>
<tr><td></td></tr>
<% 
	String sapplcount=(String)request.getAttribute(dname2+"applcount");
	int applcount = Integer.parseInt(sapplcount);
	int j1=0;
	for(int temp1=0;temp1<applcount;temp1++)
	{
		j1++;
		String aname2 = aname + Integer.toString(j1);
	%>
<div id=dum><tr><td class="check1"><input type="checkbox" name="applications" value="<%=(String)request.getAttribute(dname2+aname2)%>"> <%=(String)request.getAttribute(dname2+aname2) %></td></tr></div>
<tr></tr>
<tr></tr>
<tr></tr>

<%
}
%>
<tr></tr>
<tr></tr><tr></tr>
<tr></tr><tr></tr>
<tr></tr>
<tr><td><center><input class="subbtn" type = "submit" name ="HealthCheck" value="Perform Health Check" onclick="progress()"></center></td></tr>
</table>
</div>
</center>
<br>
<%
}%>
<center>
<br><br>
<div id=loader style="visibility:hidden;" class="loader">
</center>
</form>
<script type="text/javascript">tes();</script>	
<script>
$(document).ready(function(e){
$(".button").click(function(){
 
		$(".inv").hide();
		$("#"+$(this).val()).toggle(); 	 

}
);	
}
);

$(document).ready(function(e)
{
	$(".checkallbtn").click(function()
			{
		 			$('input:checkbox:visible').not(this).prop('checked', this.checked);
		
			}
	);
}
);

$(document).ready(function () {
    $(".subbtn").click(function() {
      checked = $("input[type=checkbox]:checked").length;

      if(!checked) {
        alert("You must check at least one checkbox.");
        return false;
      }

    });
});
</script>
</body>
</html>