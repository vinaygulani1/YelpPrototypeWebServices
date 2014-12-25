<!DOCTYPE html>
<%@page import="Connection.Review"%>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
    <link rel='stylesheet' href='/stylesheets/style.css' />
    
    <script>
    function editreview(i){
    	alert("edit review");
    	editform=document.getElementById("editform"+i);
    	editform.setAttribute("method","post");
    	editform.setAttribute("action","EditReview");
    	//document.editform.action="updateReview";
    	editform.submit();
    	
    }
    
    function deletereview(i){
    	alert("edit review");
    	editform=document.getElementById("editform"+i);
    	editform.setAttribute("method","post");
    	editform.setAttribute("action","DeleteReview");
    	//document.editform.action="deleteReview";
    	editform.submit();
    }
    </script>
    
</head>
<%if(null!= request.getSession().getAttribute("fname")) {%>
<body>
<jsp:include page="reviewSubmission.jsp" />
<hr>
<br><br>

<h2><p style="color:#a50508; font-weight: bold; font-size: x-large; text-align: center; ">All Your Reviews Below</p><h2>
<br><br><br>
<div style="margin-left: 25%; margin-right: 25%; ">


<% if(null!=request.getAttribute("reviews")) { 
	Review[] reviews = (Review[])request.getAttribute("reviews");	
	for(int i=0;i<reviews.length;i++){ %>

<form name="editform<%= i%>" id="editform<%= i%>" onsubmit="perform()" method="post">

<table>
<tr>
<td><label >Name</label></td>
<td><input  type="text" name="name" value="<%= reviews[i].getName()%>" readonly="readonly" ></td>
</tr>


<tr>
<td><label >Description</label></td>
<td><input  type="text" name="description" value=<%= reviews[i].getDescription()%>></td>
</tr>

<tr>
<td><label>Rating</label></td>
<td><input  type="text" name="rating" value=<%= reviews[i].getRating()%>  "></td>
</tr>

<tr>
<td><label  >Review</label></td>
<td><textarea  name="review" rows="4" cols="50" style="background-color: #fdffcd;" name="review" ><%= reviews[i].getReview()%></textarea></td>
</tr>

</table>

<input type="button" value="update review" onclick="editreview(<%= i%>)"  style="background:#a50508; color:white;">
<input type="button" value="delete review" onclick="deletereview(<%= i%>)"  style="background:#a50508; color:white;">
</form>

<br>

<hr>
<% } } %>
</div>

</body>
<%} else{ %>
<jsp:include page="signout.jsp" />
<%} %>
</html>