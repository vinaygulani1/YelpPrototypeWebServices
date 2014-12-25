<!DOCTYPE html>
<%@page import="Connection.Category"%>
<%@page import="Connection.Review"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <link rel='stylesheet' href='../stylesheets/style.css' />
</head>
<%if(null!= request.getSession().getAttribute("fname")) {%>
<body>
			<div class="app-header simple-header">
    		<div class="header-container clearfix">
        			<h1 class="logo">
        			<a href="home.jsp" >Yelp</a>
    				</h1> 
                 	<label style="color:white; text-align: right;margin-left:80%;font-weight: bold;font-size: 15px;"><%=  request.getSession().getAttribute("fname")%></label>  
               		<a method="get" style="color:white;margin-left: 45%; font-weight: bold;margin-left:45%;" href="reviewSubmission.jsp">WriteReview </a>
                    <label style="text-align:right;color:white;font-weight: bold; margin-left:18%;"> <%= request.getSession().getAttribute("time") %></label>
    				 <a style="text-align:right;color:white;font-weight: bold; margin-left:80%" href="SignOut" >Signout</a>	
         	</div>
         	</div>
	<jsp:include page="successLogin.jsp" />
<!--<table id="table" style = "border-color: blue;border: 3px;margin-left:24px; color:blue; border-width: thick;">
<tr >
<td border="2"  >Categories</td>
</tr>-->


<div style="float: left;">
<div>
<h5>Category</h5>
<form  action="GetNames" method="post">
<select onchange='this.form.submit()' name="category" id="category">
  <option value="Default" >Select Category</option>
  <option value="Chinese" >Chinese</option>
  <option value="Automotive">Automotive</option>
  <option value="Restaurants" >Restaurants</option>
  <option value="Food">Food</option>
  <option value="Health & Medical">Health & Medical</option>
   <option value="Coffee & Tea">Coffee & Tea</option>
   <option value="Bars">Bars</option>
</select>
</form>

</div style="float left">

<div>
<h5>Name</h5>

<form  action="ShowAllReview" method="post">
<select onchange='this.form.submit()' name="name1" id="name">
<option value="Default">Select Name</option>
<% if(null!=request.getAttribute("categoryNames")) { 
Category[] cat=(Category[])request.getAttribute("categoryNames");
for(int i=0;i<cat.length;i++){ %>
<option value="<%= cat[i].getName()%>" ><%= cat[i].getName() %></button>
<% } }%>
</select>
</form>
</div>
</div>
<div style="margin-left: 50%; background-color: #FCFCFC ">

<hr>
<br><br>

<h2><p style="color:#a50508; font-weight: bold; font-size: x-large; text-align: center; ">All Selected Category Reviews Below : </p><h2>

<% 
if(null!=request.getAttribute("reviews")) { 
Review[] reviews = (Review[])request.getAttribute("reviews");	

for(int i=0;i<reviews.length;i++){ %>
<table>
<tr>
<td><label >Name</label></td>
<td><label  style="color: black;" ><%= reviews[i].getName()%></label></td>
</tr>


<tr>
<td><label >Description</label></td>
<td><label  style="color: black;" > <%= reviews[i].getDescription()%></label></td>
</tr>

<tr>
<td><label>Rating</label></td>
<td><label  style="color: black;" ><%= reviews[i].getRating()%></label></td>
</tr>

<tr>
<td><label  >Review</label></td>
<td><label  style="color: black;" ><%= reviews[i].getReview()%></label></td>
</tr>

</table>
<% }}%>


<br>

<hr>


</div>


<table id="names">

</table>


</body>
<%} else{ %>
<jsp:include page="signout.jsp" />
<%} %>
</html>