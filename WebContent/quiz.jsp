<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <!-- Include _head.html file - Tan Tho Nguyen -->
  <%@include file='_head.html'%></td>
  <body>
    <!-- Include _nav.jsp file - Tan Tho Nguyen -->
    <%@include file='_nav.jsp'%></td>
      
      
      
    <!-- Page Content -->
    <div id="page-content-wrapper">
      <div class="container-fluid">
        <h2 class="text-primary">Servlet Quizz</h2>
        <div class="row">
        	<c:forEach var="question" items="${questions}">
        	

	          <div class="col-xs-3 col-md-8 col-sm-12 question_box">
	            <div class="modal-content">
	                <div class="modal-header">
	                    <h4 class="text-muted">
	                      <b>
	                        ${question.questionContent}
	                      </b>
	                    </h4>
	                </div>
	                <div class="modal-body">
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
	                    <div class="quiz" id="quiz" data-toggle="buttons">
	                    	<c:forEach var="pAnswer" items="${question.lstPossibleAnswer}">
	                    		<label class="element-animation1 btn btn-lg btn-primary btn-block">
	                        	<span class="btn-label"><i class="glyphicon glyphicon-chevron-right"></i></span> <input type="radio" name="q_answer" value="1">${pAnswer.text}
	                        </label>
												</c:forEach>
	                   </div>
	                </div>

	            </div>

	          </div>
	        </c:forEach>

        </div>

      </div>
    </div>

    <!-- /#page-content-wrapper -->
  </body>
</html>




























