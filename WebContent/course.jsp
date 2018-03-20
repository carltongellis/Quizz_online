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
        <ul class="bs-box clerfix">
          <c:forEach var="course" items="${listCourse}">
            <li class="col-md-4 col-sm-12 col-xs-12">
              <a class="panel panel-default" href="Course?bCourse=${course.name}">
                <div class="panel-header text-center text-primary">
                  <h3>${course.name}</h3>
                </div>
                <div class="panel-body">
                  <p>${course.description}</p>
                </div>
                <div class="panel-footer">
                  <button class="btn btn-primary btn-block"><b>Click to start</b></button>
                </div>
              </a>
            </li>
          </c:forEach>
        </ul>
      </div>
    </div>
  </body>
</html>
