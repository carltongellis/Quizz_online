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
        <div class="col-md-12 col-sm-12 col-xl-12">
          <!-- Show table history - Tan Tho Nguyen -->
          <c:forEach var="course" items="${mapCourseQuiz}">
            <c:if test="${!course.value.isEmpty()}">
              <h3>${course.key.getName()}</h3>
              <table class="table table-hover">
                <tr class="active">
                  <th>Date taken</th>
                  <th>Score</th>
                  <th>Result</th>
                  <th>Action</th>
                </tr>
                <c:forEach var="quiz" items="${course.value}">
                  <tr class="${quiz.getScore() >= 8 ? 'success' : 'danger'}">
                    <td>${quiz.getDateTaken()}</td>
                    <td>${quiz.getScore()}</td>
                    <td>${quiz.getScore() >= 8 ? "Passed" : "Failed"}</td>
                    <td>
                      <a href="Course?bCourse=${course.key.getId()}" class="">Retake</a>
                    </td>
                  </tr>
                
                </c:forEach>
              </table>
            </c:if>
          </c:forEach>
        </div>
      </div>
    </div>
  </body>
</html>