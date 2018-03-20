<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <!-- Include _head.html file - Tan Tho Nguyen -->
  <%@include file='_head.html'%></td>
  <body>
    <!-- Include _nav.html file - Tan Tho Nguyen -->
    <%@include file='_nav.jsp'%></td>
      
      
      
    <div class="container">
      <div class="row main">
        <div class="form-header">
          <h1 class="text-center ">Login form </h1>
        </div>
        <div class="main-content">
          <form action="Login" method="post">
            <div id="message" class="text-danger">
              ${error}
            </div>  

            <div class="input-group ">
              <span class="input-group-addon"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span></span>
              <input id="username" type="text" class="form-control" name="username" placeholder="Username">
            </div>
            <div class="input-group">
              <span class="input-group-addon"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>
              <input id="password" type="password" class="form-control" name="password" placeholder="Password">
            </div>
            
            <div class="form-group ">
                <input type="submit" class="btn btn-primary btn-lg btn-block login-button" value="Login" />
            </div>
          </form>




            
            
        </div>
      </div>
    </div>
  </body>
</html>