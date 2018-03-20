$(function(){
  // Highlight current page navigation link - Tan Tho Nguyen
  highlight();

  // Check AJAX call to display loading icon - Tan Tho Nguyen
  var loading = $('#loadbar').hide();
  $(document)
  .ajaxStart(function () {
    loading.show();
  }).ajaxStop(function () {
    loading.hide();
  });

  // $("label.btn").on('click',function () {
  //   var choice = $(this).find('input:radio').val();
  //   $('#loadbar').show();
  //   $('#quiz').fadeOut();
  //   setTimeout(function(){
  //     $( "#answer" ).html(  $(this).checking(choice) );      
  //     $('#quiz').show();
  //     $('#loadbar').fadeOut();
  //     /* something else */
  //   }, 1500);
  // });



  // Call AJAX to submit form Signup - Tan Tho Nguyen
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
        $("#message").removeClass("alert alert-success").addClass("alert alert-danger");;
        for (var i = 0; i < data.message.length; i++) {
          $("#message").append("<li>" + data.message[i] + "</li>");
        }
      } else {
        $("#message").removeClass("alert alert-danger").addClass("alert alert-success");;
        $("#message").append("<li>Register successfull</li>");
        window.location.href = "/Quizz_online/login.jsp";
      }
      $("#message").append("</ul>");
    });

    e.preventDefault();
  });



  // Call AJAX to submit form Update profile - Tan Tho Nguyen
  $("form#formUpdateProfile").submit(function(e) {

    $.ajax({
      url: "Profile",
      type: "POST",
      data: {
        userName: $("input[name=userName]").val(),
        email: $("input[name=email]").val(),
        newPassword: $("input[name=newPassword]").val(),
        confirmNewPassword: $("input[name=confirmNewPassword]").val()
      }
    }).done(function (data) {
      $("#message").html("");
      $("#message").append("<ul>");
      if (data.result == "failed") {
        $("#message").removeClass("alert alert-success").addClass("alert alert-danger");;
        for (var i = 0; i < data.message.length; i++) {
          $("#message").append("<li>" + data.message[i] + "</li>");
        }
      } else {
        $("#message").removeClass("alert alert-danger").addClass("alert alert-success");;
        $("#message").append("<li>Update successfull</li>");
      }
      $("#message").append("</ul>");
    });

    e.preventDefault();
  });




  // Call AJAX to submit form Exam - Tan Tho Nguyen
  $("form#formExam").submit(function(e) {
    var json = {}

    $("form#formExam label.active .value").each(function() {
      obj[''] = $( this ).text();
    });

    // $.ajax({
    //   url: "Course",
    //   type: "POST",
    //   data: {
    //     userName: $("input[name=userName]").val(),
    //     email: $("input[name=email]").val(),
    //     newPassword: $("input[name=newPassword]").val(),
    //     confirmNewPassword: $("input[name=confirmNewPassword]").val()
    //   }
    // }).done(function (data) {
    //   $("#message").html("");
    //   $("#message").append("<ul>");
    //   if (data.result == "failed") {
    //     $("#message").removeClass("alert alert-success").addClass("alert alert-danger");;
    //     for (var i = 0; i < data.message.length; i++) {
    //       $("#message").append("<li>" + data.message[i] + "</li>");
    //     }
    //   } else {
    //     $("#message").removeClass("alert alert-danger").addClass("alert alert-success");;
    //     $("#message").append("<li>Update successfull</li>");
    //   }
    //   $("#message").append("</ul>");
    // });

    e.preventDefault();
  });



  // Highlight current page navigation link - Tan Tho Nguyen
  function highlight() {
    var url = window.location.href;
    var activePage = url;
    $('ul.nav a').each(function () {
        var linkPage = this.href;

        if (activePage == linkPage) {
            $(this).closest("li").addClass("active");
        }
    });

    if (activePage.indexOf("index") >= 0) {
      $("li.index").addClass("active");
    }
  }

}); 
