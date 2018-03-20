<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ShowProfile" method="post">
	<div>User Name <input type="text" name="userName"/></div>
	<div>Email <input type="text" name="email"/></div>
	<div>New Password <input type="password" name="newPassword"/></div>
	<div>Confirm password <input type="password" name="confirmNewPassword"/></div>
<!-- 	<div><input type="button" name="save" value="Save changes" /></div> -->
	<button name="button" value="save">Save changes</button>
	<button name="button" value="cancel">Cancel</button>
</form>
</body>
</html>