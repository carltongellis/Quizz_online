<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.wap.domain.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
User user = (User)request.getSession().getAttribute("user");




/*
UN: ${ user.getUsername() } <br />
UN: ${ user.email } <br />
ID: ${ user.id }
*/

%>

<%= "User Name : " + user.getUsername()%><br />
<%= "ID : " + user.getId()%>

</body>
</html>