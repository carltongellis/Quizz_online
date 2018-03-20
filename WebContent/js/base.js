$(function(){
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
      $("#error_message").html("");
      $("#error_message").append("<ul>");
      if (data.result == "failed") {
        for (var i = 0; i < data.message.length; i++) {
          $("#error_message").append("<li>" + data.message[i] + "</li>");
        }
      } else {
        $("#error_message").append("<li>Register successfull</li>");
      }
      $("#error_message").append("</ul>");
    });

    e.preventDefault();
  });

}); 
