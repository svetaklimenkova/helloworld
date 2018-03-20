$(document).ready(function () {
    loginCheck();
    mailCheck()

    $('#password').on("change paste keyup", function () {
        switchValid(this, $(this).val().length > 7);
    });

    $('#confirm').on("change paste keyup", function () {
        switchValid(this, $(this).val() === $('#password').val());
    });

    $("#btn_sign_up").click(function (event) {
        event.preventDefault();
        registerUser();
    });
});

function loginCheck() {
    $('#login').on("change paste keyup", function () {
        var elem = $(this);

        // empty login
        if(isEmpty($(this))) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#login-empty").val());
            return;
        }
        // invalid symbols
        if (!/^[a-zA-Z0-9.-_]+$/.test($(this).val())) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#login-invalid").val());
            switchValid(elem, false);
            return;
        }

        // invalid size
        if ($(this).val().length > 32 || $(this).val().length < 4) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#login-size").val());
            switchValid(elem, false);
            return;
        }

        // existed username
        $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#login-exist").val());
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "valid?username=" + $(this).val(),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                switchValid(elem, data);
            },
            error: function (e) {
                console.log(JSON.stringify(e.responseText));
            }
        });
    });
}

function mailCheck() {
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
            url: "valid?mail=" + $(this).val(),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                switchValid(elem, data);
            },
            error: function (e) {
                console.log(JSON.stringify(e.responseText));
            }
        });
    });
}

function registerUser() {
    var user = {};
    user["username"] = $("#login").val();
    user["email"] = $("#mail").val();
    user["password"] = $("#password").val();

    $("#btn_sign_up").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/signUpUser",
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

function switchValid(elem, result) {
    if (isEmpty(elem)) {
        return;
    }
    var spanCheck = $(elem).parent().find('.input-check');
    if (result) {
        if (spanCheck.hasClass('invalid')) {
            setValid(spanCheck);
            if ($('.my-form').find('.valid').length === 4) {
                $('#btn_sign_up').prop("disabled", false);
            } else {
                $('#btn_sign_up').prop("disabled", true);
            }
        }
    } else {
        if (spanCheck.hasClass('valid')) {
            setInvalid(spanCheck);
        }
    }
}

function isEmpty(elem) {
    var spanCheck = $(elem).parent().find('.input-check');

    if ($(elem).val() === "") {
        if (spanCheck.hasClass('valid')) {
            setInvalid(spanCheck);
        }
        return true;
    }
    return false;
}

function setValid(elem) {
    elem.removeClass('invalid').addClass('valid');
    elem.children('i').removeClass('glyphicon-remove').addClass('glyphicon-ok');
}

function setInvalid(elem) {
    elem.removeClass('valid').addClass('invalid');
    elem.children('i').removeClass('glyphicon-ok').addClass('glyphicon-remove');
}