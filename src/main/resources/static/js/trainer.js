$(document).ready(function () {
    checkUsername();
    checkMail();
    checkMessage();
    $("#btn_sign_up").click(function (event) {
        event.preventDefault();
        sendApplication();
    });
});

function sendApplication() {
    var application = {};
    application["username"] = $("#login").val();
    application["email"] = $("#mail").val();
    application["message"] = $("#message").val();

    $("#btn_sign_up").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/rest/applications/trainer",
        dataType: 'json',
        data: JSON.stringify(application),
        cache: false,
        timeout: 600000,
        success: function (data) {
            if (data) {
                $('.message').css('display', 'block');
            }
            $("#btn_sign_up").prop("disabled", false);
        },
        error: function (e) {
            $("#btn_sign_up").prop("disabled", false);
        }
    });
}