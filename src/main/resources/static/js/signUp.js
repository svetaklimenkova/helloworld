$(document).ready(function () {
    checkUsername();
    checkMail();
    checkPassword();
    checkPasswordConfirm();

    $("#btn_sign_up").click(function (event) {
        event.preventDefault();
        registerUser();
    });
});

function registerUser() {
    var user = {};
    user["username"] = $("#login").val();
    user["email"] = $("#mail").val();
    user["password"] = $("#password").val();

    $("#btn_sign_up").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/rest/users",
        data: JSON.stringify(user),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            if (data !== null) {
                if (data.id !== -1) {
                    window.location.href = '/';
                }
            } else {
                $('.error').css('display', 'block');
            }

            $("#btn_sign_up").prop("disabled", false);
        },
        error: function (e) {
            $('.error').css('display', 'block');
            $("#btn_sign_up").prop("disabled", false);
        }
    });
}