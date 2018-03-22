$(document).ready(function () {
    checkMail();
    $("#btn_sign_up").click(function (event) {
        event.preventDefault();
        recoveryPassword();
    });
});

function recoveryPassword() {
    $("#btn_sign_up").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/application/password?mail=" + $('#mail').val(),
        dataType: 'json',
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