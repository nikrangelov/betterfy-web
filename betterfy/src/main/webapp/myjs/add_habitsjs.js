
$( document ).ready(function() {
    $("#addHabitBtn").click( function()
        {
            var name = $('#habitName').val();
            var question = $('#habitQuestion').val();
            var times = $('#habitTimes').val();
            var days = $('#habitDays').val();


            alert(name + ' ' + question + ' ' + times + '' + days);
            //console.log( "ready!" );
            var userDetails = new Object();
            userDetails.name = name;
            userDetails.question = question;
            userDetails.times = times;
            userDetails.days = days;

            var jsonString = JSON.stringify(userDetails);
            console.log(jsonString);
            alert(jsonString);

            $.ajax({
                url: '/api/secured/habit/add',
                headers: {
                    "USER_TOKEN": localStorage.token
                },
                type: 'POST',
                data: jsonString,
                contentType: 'application/json; charset=utf-8',
                success: function (response) {
                    alert("ajax finished successfully!");
                    //$.cookie("test", 1);
                    //console.log("Debug");
                    //your success code
                    //console.log(response);
                    alert(localStorage.token);
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
