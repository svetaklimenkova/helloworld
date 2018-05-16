$(document).ready(function () {

    checkMailWithoutEmpty();
    checkPasswordWithoutEmpty();
    checkPasswordConfirmWithoutEmpty();

    $('#back').click(function () {
        window.location.href = "/trainings"
    });

    $('#btn_sign_up').click(function () {
        var data = {};
        addIfNotNull(data, 'password', $('#password').val());
        addIfNotNull(data, 'email', $('#mail').val());
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/rest/users/update",
            data: JSON.stringify(data),
            success: function (data) {
                if (data) {
                    showMessage(data.message);
                }
            },
            error: function (e) {
                throwMessage(e.responseJSON.message);
            }
        });
    });
});

function addIfNotNull(data, key, value) {
    if (value !== "") {
        data[key] = value;
    }
}