
$( document ).ready(function() {
    $("#loginBtn").click( function()
        {

            var email = $('#inputEmail').val();
            var password_v = $('#inputPassword').val();
            alert(email + ' ' + password_v);
            //console.log( "ready!" );
            var userDetails = new Object();
            userDetails.email = email;
            userDetails.password = password_v;

            var jsonString = JSON.stringify(userDetails);
            console.log(jsonString);
            alert(jsonString);

            $.ajax({
                url: 'http://localhost:8080/api/authentication',
                type: 'POST',
                data: jsonString,
                contentType: 'application/json; charset=utf-8',
                success: function (response) {
                    alert("ajax finished successfully!");
                    //$.cookie("test", 1);
                    //console.log("Debug");
                    //your success code
                    //console.log(response);
                    alert(response.token);
                },
                error: function (jqXHR, exception) {
                    //your error code
                    alert("ajax not finished successfully!" + jqXHR.status);
                    console.log("Debug 1");
                }
            });
        }
    );

    //console.log( "ready!" );
});



/*
$( document ).ready(function() {
$(function() {
    $('login-form').on('submit', function(e) {
        $.post('http://localhost:8080/api/authentication', $(this).serialize(), function (data) {
            alert("ok");
            alert(data);
            // This is executed when the call to mail.php was succesful.
            // 'data' contains the response from the request
        }).error(function() {
            alert("error");
            // This is executed when the call to mail.php failed.
        });
        e.preventDefault();
    });
});

});
*/








/*
 $(function() {
 $('form#myForm').on('submit', function(e) {
 $.post('mail.php', $(this).serialize(), function (data) {
 // This is executed when the call to mail.php was succesful.
 // 'data' contains the response from the request
 }).error(function() {
 // This is executed when the call to mail.php failed.
 });
 e.preventDefault();
 });
 });
 */
/*
 * $.ajax({
 url: 'url',
 type: 'GET',
 data: { field1: "hello", field2 : "hello2"} ,
 contentType: 'application/json; charset=utf-8',
 success: function (response) {
 //your success code
 },
 error: function () {
 //your error code
 }
 });
 *
 */