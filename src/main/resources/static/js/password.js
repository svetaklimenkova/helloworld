$(document).ready(function () {
    checkMailOnExistense();
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
        url: "/rest/applications/password?mail=" + $('#mail').val(),
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

function checkMailOnExistense() {
    $('#mail').on("change paste keyup", function () {
        var elem = $(this);

        // empty login
        if(isEmpty($(this))) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#mail-empty").val());
            return;
        }

        // invalid size
        if ($(this).val().length > 255 || $(this).val().length < 5) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#mail-size").val());
            switchValid(elem, false);
            return;
        }

        // invalid symbols
        if (!/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test($(this).val())) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#mail-invalid").val());
            switchValid(elem, false);
            return;
        }

        // existed username
        $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#mail-exist").val());
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/rest/users/valid?mail=" + $(this).val(),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                switchValid(elem, !data);
            },
            error: function (e) {
                console.log(JSON.stringify(e.responseText));
            }
        });
    });
}