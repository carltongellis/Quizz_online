<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="js/base.js" type="text/javascript"></script>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
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
        <a class="navbar-brand" href="">
          <img alt="logo" src="img/logo.png" class="logo">
        </a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        
        
        <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="">Home</a></li>
          <li><a href="About_UI.html">About Us</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Courses <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="#">FPP</a></li>
              <li><a href="#">MPP</a></li>
              <li><a href="#">WAP</a></li>
            </ul>
          </li>
          <li><a href="#">History</a></li>
          <li><a href="#">Profile</a></li>
          <li><a href="Login_UI.html">Login</a></li>
          <li><a href="Signup_UI.html">Signup</a></li>
          
        </ul>
      </div><!-- /.navbar-collapse -->
        </div><!-- /.container-collapse -->
    </nav>
      
      
      
    <div class="container">
      <div class="row main">
        <div class="form-header">
          <h1 class="text-center ">Login form </h1>
        </div>
        <div class="main-content">
          <form action="Login" method="post">
            <div class="text-danger">
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
                <input type="submit" class="btn btn-danger btn-lg btn-block login-button" value="Login" />
            </div>
          </form>




            
            
        </div>
      </div>
    </div>
  </body>
</html>