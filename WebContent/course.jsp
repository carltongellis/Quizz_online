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
      <table class="table">
		<tr><th>CourseID</th><th>CourseName</th><th>Description</th></tr>
		<c:forEach var="course" items="${listCourse}">
			<tr>
				<td>${course.id}</td><td>${course.name}</td><td>${course.description}</td>
			</tr>
		</c:forEach>
	</table>
        <hr/>
        <ul class="bs-box clerfix">
            <li class="col-md-4 col-sm-12 col-xs-12">
                <a class="panel panel-default" href="courseController?bCourse=FPP">
                    <div class="panel-body text-center">
                        <h3>FPP</h3>
                        <p><button class="btn btn-primary">Click to start</button></p>
                    </div>
                </a>
            </li><li class="col-md-4 col-sm-12 col-xs-12">
                <a class="panel panel-default" href="courseController?bCourse=MPP">
                    <div class="panel-body text-center">
                        <h3>MPP</h3>
                        <p><button class="btn btn-primary">Click to start</button></p>
                    </div>
                </a>
            </li><li class="col-md-4 col-sm-12 col-xs-12">
                <a class="panel panel-default" href="courseController?bCourse=A Basic Panel">
                    <div class="panel-body text-center">
                        <h3>A Basic Panel</h3>
                        <p><button class="btn btn-primary">Click to start</button></p>
                    </div>
                </a>
            </li><li class="col-md-4 col-sm-12 col-xs-12">
                <a class="panel panel-default" href="courseController?bCourse=A Basic Panel">
                    <div class="panel-body text-center">
                        <h3>A Basic Panel</h3>
                        <p><button class="btn btn-primary">Click to start</button></p>
                    </div>
                </a>
            </li><li class="col-md-4 col-sm-12 col-xs-12">
                <a class="panel panel-default" href="courseController?bCourse=A Basic Panel">
                    <div class="panel-body text-center">
                        <h3>A Basic Panel</h3>
                        <p><button class="btn btn-primary">Click to start</button></p>
                    </div>
                </a>
            </li><li class="col-md-4 col-sm-12 col-xs-12">
                <a class="panel panel-default" href="courseController?bCourse=A Basic Panel">
                    <div class="panel-body text-center">
                        <h3>A Basic Panel</h3>
                        <p><button class="btn btn-primary">Click to start</button></p>
                    </div>
                </a>
            </li><li class="col-md-4 col-sm-12 col-xs-12">
                <a class="panel panel-default" href="courseController?bCourse=A Basic Panel">
                    <div class="panel-body text-center">
                        <h3>A Basic Panel</h3>
                        <p><button class="btn btn-primary">Click to start</button></p>
                    </div>
                </a>
            </li><li class="col-md-4 col-sm-12 col-xs-12">
                <a class="panel panel-default" href="courseController?bCourse=A Basic Panel">
                    <div class="panel-body text-center">
                        <h3>A Basic Panel</h3>
                        <p><button class="btn btn-primary">Click to start</button></p>
                    </div>
                </a>
            </li><li class="col-md-4 col-sm-12 col-xs-12">
                <a class="panel panel-default" href="courseController?bCourse=A Basic Panel">
                    <div class="panel-body text-center">
                        <h3>A Basic Panel</h3>
                        <p><button class="btn btn-primary">Click to start</button></p>
                    </div>
                </a>
            </li><li class="col-md-4 col-sm-12 col-xs-12">
                <a class="panel panel-default" href="courseController?bCourse=A Basic Panel">
                    <div class="panel-body text-center">
                        <h3>A Basic Panel</h3>
                        <p><button class="btn btn-primary">Click to start</button></p>
                    </div>
                </a>
            </li><li class="col-md-4 col-sm-12 col-xs-12">
                <a class="panel panel-default" href="courseController?bCourse=A Basic Panel">
                    <div class="panel-body text-center">
                        <h3>A Basic Panel</h3>
                        <p><button class="btn btn-primary">Click to start</button></p>
                    </div>
                </a>
            </li><li class="col-md-4 col-sm-12 col-xs-12">
                <a class="panel panel-default" href="courseController?bCourse=A Basic Panel">
                    <div class="panel-body text-center">
                        <h3>A Basic Panel</h3>
                        <p><button class="btn btn-primary">Click to start</button></p>
                    </div>
                </a>
            </li>
        </ul>
      </div>
    </div>
  </body>
</html>
