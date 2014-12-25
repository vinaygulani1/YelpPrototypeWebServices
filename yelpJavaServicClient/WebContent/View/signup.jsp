<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel='stylesheet' href='../stylesheets/style.css' />
    <link rel='stylesheet' href='../stylesheets/bootstrap.min.css' />
	<jsp:include page="header.html" />
<%-- 	<%@ include file="header.html" %> --%>
</head>
    
<body>
<form  action="SignUp"  method="post">
<table simple-header">
<br>
<tr>
<td>First Name</td>
<td><input type="text" name='fname'></td>
</tr>

<tr>
<td>Last Name</td>
<td><input type="text" name='lname'></td>
</tr>

<tr>
<td>Email</td>
<td><input type="email" name='email'></td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name='pswd'></td>
</tr>
</table>

<input type="submit" value="submit">
</form>
</body>
</html>
