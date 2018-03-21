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
        	<div class="col-xs-12 col-md-8 col-sm-12 question_box">
	          <form id="formExam" method="GET">

	          
	            <c:forEach var="question" items="${questions}">
	            

	              <div class="col-xs-12 col-md-12 col-sm-12 question_box">
	                <div class="modal-content">
	                    <div class="modal-header">
	                        <h4 class="text-muted">
	                          <b>
	                            ${question.questionContent}
	                          </b>
	                        </h4>
	                    </div>
	                    <div class="modal-body answers">
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
	                              <span class="btn-label"><i class="glyphicon glyphicon-chevron-right"></i></span> <input type="radio" name="qid_${question.id}" class="answer">
	                              <span class="value">${pAnswer.text}</span>
	                            </label>
	                          </c:forEach>
	                       </div>
	                    </div>

	                </div>

	              </div>
	            </c:forEach>

	          </form>
	        </div>

          <div class="col-xs-12 col-md-4 col-sm-12 result_box">

            <div class="panel-header text-center text-primary">
              <h2>Timer</h2>
            </div>
            <div class="panel-body">
              <h3 id="timer" class="text-center text-danger"></h3>
            </div>
            <div class="panel-footer text-center">
              <input type="submit" id="btnSubmitResult" class="btn btn-primary btn-lg btn-block" value="Submit" form="formExam">
            </div>
          	
          </div>
        </div>


        <div id="modalResult" class="modal" tabindex="-1" role="dialog">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h2 class="modal-title text-primary">Result</h2>
              </div>
              <div class="modal-body">
                <p>Modal body text goes here.</p>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-primary">Select course</button>
                <!-- <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> -->
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>

    <!-- /#page-content-wrapper -->
  </body>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/timer.jquery/0.6.5/timer.jquery.min.js" type="text/javascript"></script>
</html>




























