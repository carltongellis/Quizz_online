<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <!-- Include _head.html file - Tan Tho Nguyen -->
  <%@include file='_head.html'%></td>
  <body>
    <!-- Include _nav.jsp file - Tan Tho Nguyen -->
    <%@include file='_nav.jsp'%></td>
      
      
      
    <div class="container">
      <div class="row">
    <!-- edit form column -->
      <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
        <!-- <div class="alert alert-info alert-dismissable">
          <a class="panel-close close" data-dismiss="alert">×</a> 
          <i class="fa fa-coffee"></i>
          This is an <strong>.alert</strong>. Use this to show important messages to the user.
        </div> -->
        <h3>Personal info</h3>
        <form class="form-horizontal" role="form" action="Profile" method="post">
          <div class="form-group">
            <label class="col-md-3 control-label">Username:</label>
            <div class="col-md-8">
              <input class="form-control" value="${user.getUsername()}" type="text" name="userName" readonly>
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">Email:</label>
            <div class="col-md-8">
              <input class="form-control" value="${user.getEmail()}" type="text" name="email">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">Password:</label>
            <div class="col-md-8">
              <input class="form-control" type="password" name="newPassword">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">Confirm password:</label>
            <div class="col-md-8">
              <input class="form-control" type="password" name="confirmNewPassword">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label"></label>
            <div class="col-md-8">
              <input class="btn btn-primary" value="Save Changes" type="submit">
              <span></span>
              <input class="btn btn-default" value="Reset" type="reset">
            </div>
          </div>
        </form>
      </div>
      </div>
    </div>
  </body>
</html>
