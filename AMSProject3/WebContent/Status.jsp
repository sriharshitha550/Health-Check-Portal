<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Status page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

<style>


body{
margin:0;

}


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
.downd
{
float:right;
}

.btn-info
{
background-color: white;
}
</style>
</head>
<body>


<ul>
  		<li class="home"><a href="home.jsp"><i class="fa fa-home"></i>HOME</a>
  		<li class="name1"><img src="http://i.dell.com/images/global/brand/ui/logo-wt-bl.png" width="45"  height="45" alt="Dell" title="Dell" border="0"></li>
		<li class="name">AMS Health Check Portal</li>
</ul>
<center>
<p>&#9993;</p>
</center>
<div class="downd">

<button class="btn btn-info" onclick="printDiv('HTMLtoPDF')"></i><i class="fa fa-download" style="font-size:26px;color:#007DB8"></i>
</button>
</div>


<center id="HTMLtoPDF"> 
<style>
.s
{
	background-color: #B7295A;
	color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration:none;
    font-family: "ETmodules";
   	font-size: 18px;
	font-weight: 800;
	border: none;
	width:20%;
}
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 80%;
    font-size: 4px;
    
    
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
    font-size:8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}






</style>

<br><br>
<div class="t4">
<h1 class="s">Overall Status</h1>
<table>
<tr>
<th></th>
<th>Green</th>
<th>Red</th>
</tr>
<tr>
<th>Window Services</th>
<td><%=(int)request.getAttribute("gcount")%></td>
<td><%=(int)request.getAttribute("rcount")%></td>
</tr>
<tr>
<th>URL Checks</th>
<td><%= (int)request.getAttribute("ugcount")%></td>
<td><%= (int)request.getAttribute("urcount")%></td>
</tr>
<tr>
<th>Middleware Checks</th>
<td><%= (int)request.getAttribute("mgcount")%></td>
<td><%= (int)request.getAttribute("mrcount")%></td>
</tr>
</table>

</div>
<br><br>
<div class="t1">
<h1 class="s">Window Services</h1>
<table>
<tr>
<th>Application</th>
<th>Region</th>
<th>Server</th>
<th>Service</th>
<th>Expected Status</th>
<th>Actual Status</th>
</tr> 
<%
String[] array= (String[])request.getAttribute("keys");
for(int j=0;j<array.length;j++)
{
int kcount=	(Integer)request.getAttribute(array[j]+"count");
for(int i=1;i<=kcount;i++)
{
	String x=Integer.toString(i);
%>
	<tr>
	<td><%=request.getAttribute(array[j]+x+"Appl")%></td>
	<td><%=request.getAttribute(array[j]+x+"Region")%></td>
	<td><%=array[j]%></td>
		<td><%=request.getAttribute(array[j]+x+"Service")%></td>
		
		<%
if(((String)request.getAttribute(array[j]+x+"Exstatus")).equals(((String)request.getAttribute(array[j]+x+"Astatus"))))
{
	%>
	<td bgcolor=" #9ACD32"><%= (String)request.getAttribute(array[j]+x+"Exstatus")%></td>
	<td bgcolor=" #9ACD32"><%= (String)request.getAttribute(array[j]+x+"Astatus")%></td>
	<%	
}
else
{
%>
<td bgcolor="#FF0000"><%= (String)request.getAttribute(array[j]+x+"Exstatus")%></td>
<td bgcolor="#FF0000"><%= (String)request.getAttribute(array[j]+x+"Astatus")%></td>
<%} %>
	</tr>
		
<%
}//i for loop
		
}//j for loop
%>

</table>
</div>

<br><br>
<h1 class="s">URL Checks</h1>
<table>
<tr>
<th>Application</th>
<th>Region</th>
<th>URL</th>
<th>Component</th>
<th>Status</th>
</tr>
<%
String[] uarray= (String[])request.getAttribute("ukeys");
for(int j=0;j<uarray.length;j++)
{
int kcount=	(Integer)request.getAttribute(uarray[j]+"count");
for(int i=1;i<=kcount;i++)
{
	String x=Integer.toString(i);
%>
<tr>
	<td><%=request.getAttribute(uarray[j]+x+"Appname")%></td>
	<td><%=request.getAttribute(uarray[j]+x+"uregion")%></td>
	<td><%=request.getAttribute(uarray[j]+x+"Url")%></td>
	<td><%=request.getAttribute(uarray[j]+x+"component")%></td>
	

	<%
	if(request.getAttribute(uarray[j]+x+"Status").equals("Up"))
	{
	%>
	<td bgcolor="#9ACD32"><%=request.getAttribute(uarray[j]+x+"Status")%></td>
	<%
	}
	else
	{
	%>
	<td bgcolor="#FF0000"><%=request.getAttribute(uarray[j]+x+"Status")%></td>
	<%
	}%>
	
</tr>
<%
}
}
%>

</table>




<br><br>
<h1 class="s">Middleware Checks(MQ Depth)</h1>
<table class="t3">
<tr>
<th>Application</th>
<th>Region</th>
<th>Host</th>
<th>Queue Manager</th>
<th>Queue Channel</th>
<th>Port</th>
<th>Queue Name</th>
<th>Threshold</th>
<th>Queue Depth</th>
</tr>
<%
String[] qarray= (String[])request.getAttribute("qkeys");
for(int j=0;j<qarray.length;j++)
{
int kcount=	(Integer)request.getAttribute(qarray[j]+"countq");
for(int i=1;i<=kcount;i++)
{
	String x=Integer.toString(i);
%>
<tr>
	<td><%=qarray[j]%></td>
	<td><%=request.getAttribute(qarray[j]+x+"qregion")%></td>
	<td><%=request.getAttribute(qarray[j]+x+"qhost")%></td>
	<td><%=request.getAttribute(qarray[j]+x+"qmanager")%></td>
	<td><%=request.getAttribute(qarray[j]+x+"qchannel")%></td>
	<td><%=request.getAttribute(qarray[j]+x+"qport")%></td>
	<td><%=request.getAttribute(qarray[j]+x+"qname")%></td>
	<%
	int ithold = (int)request.getAttribute(qarray[j]+x+"threshold");
	int iqdepth =(int)request.getAttribute(qarray[j]+x+"Qdepth");
	if(iqdepth < ithold)
	{
	%>
	
	<td bgcolor="#9ACD32"><%=request.getAttribute(qarray[j]+x+"threshold")%></td>
	<td bgcolor="#9ACD32"><%=request.getAttribute(qarray[j]+x+"Qdepth")%></td>
	<%
	}
	else
	{
	%>
	<td bgcolor="#FF0000"><%=request.getAttribute(qarray[j]+x+"threshold")%></td>
	<td bgcolor="#FF0000"><%=request.getAttribute(qarray[j]+x+"Qdepth")%></td>
	<%
	}
	%>
</tr>
<%
}
}
%>

</table>

</center>
	<!-- here we call the function that makes PDF -->
	

	<!-- these js files are used for making PDF -->
	<script src="js/jspdf.js"></script>
	<script src="js/jquery-2.1.3.js"></script>
	<script src="js/pdfFromHTML.js"></script>
	<script>
	function printDiv(divName) {
    Print(divName);
   }
  function Print(divName){
    var printContents = document.getElementById(divName).innerHTML;
      var originalContents = document.body.innerHTML;
      document.body.innerHTML = printContents;
     window.print();
  } 
</script>
</body>
</html>