$(function(){
  // Check AJAX call to display loading icon - Tan Tho Nguyen
  var loading = $('#loadbar').hide();
  $(document)
  .ajaxStart(function () {
    loading.show();
  }).ajaxStop(function () {
    loading.hide();
  });

  $("label.btn").on('click',function () {
    var choice = $(this).find('input:radio').val();
    $('#loadbar').show();
    $('#quiz').fadeOut();
    setTimeout(function(){
      $( "#answer" ).html(  $(this).checking(choice) );      
      $('#quiz').show();
      $('#loadbar').fadeOut();
      /* something else */
    }, 1500);
  });



  // Call AJAX to submit form - Tan Tho Nguyen
  $("form#formSignup").submit(function(e) {

    $.ajax({
      url: "SignUp",
      type: "POST",
      data: {
        userName: $("#userName").val(),
        userEmail: $("#userEmail").val(),
        userPass: $("#userPass").val()
      }
    }).done(function (data) {
      $("#message").html("");
      $("#message").append("<ul>");
      if (data.result == "failed") {
        $("#message").removeClass("text-primary").addClass("text-danger");;
        for (var i = 0; i < data.message.length; i++) {
          $("#message").append("<li>" + data.message[i] + "</li>");
        }
      } else {
        $("#message").removeClass("text-danger").addClass("text-primary");;
        $("#message").append("<li>Register successfull</li>");
        window.location.href = "/Quizz_online/login.jsp";
      }
      $("#message").append("</ul>");
    });

    e.preventDefault();
  });

}); 
