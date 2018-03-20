<%@ page import = "com.wap.domain.User" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<% User user = (User) request.getSession().getAttribute("user"); %>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/Quizz_online">
      	<img alt="logo" src="img/logo.png" class="logo">
      </a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      <ul class="nav navbar-nav navbar-right">
        <li class="index"><a href="/Quizz_online">Home</a></li>
        <li><a href="about.jsp">About Us</a></li>
        <!-- Check user status - Tan Tho Nguyen -->
        <c:if test = "${user != null}">
          <li><a href="Courses">Courses</a></li>
          <li><a href="#">History</a></li>
          <li><a href="profile.jsp">Profile</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Hi ${user.getUsername()} <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="Logout">Logout</a></li>
            </ul>
          </li>
        </c:if>

        <!-- Check user status - Tan Tho Nguyen -->
        <c:if test = "${user == null}">
          <li><a href="login.jsp">Login</a></li>
          <li><a href="signup.jsp">Signup</a></li>
        </c:if>
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-collapse -->

  <!-- Loading icon - Tan Tho Nguyen -->
  <div id="loadbar" style="display: none;">
    <div class="blockG" id="rotateG_01"></div>
    <div class="blockG" id="rotateG_02"></div>
    <div class="blockG" id="rotateG_03"></div>
    <div class="blockG" id="rotateG_04"></div>
    <div class="blockG" id="rotateG_05"></div>
    <div class="blockG" id="rotateG_06"></div>
    <div class="blockG" id="rotateG_07"></div>
    <div class="blockG" id="rotateG_08"></div>
  </div>
</nav>