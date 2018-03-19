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
      data: {
        userName: $("#userName").val(),
        userEmail: $("#userEmail").val(),
        userPass: $("#userPass").val()
      }
    }).done(function (data) {
      $("#text-danger").html();
      $("#text-danger").append(data.message[0]);
      if (data.result == "failed") {
        for (var i = 0; i < data.message.length; i++) {
          $("#text-danger").append(data.message[i]);
        }
      }
    });

    e.preventDefault();
  });

}); 
