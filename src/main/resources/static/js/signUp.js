$(document).ready(function () {
    $('#login').on("change paste keyup", function () {
        var elem = $(this);
        if(isEmpty($(this))) {
            return;
        }

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

    $('#mail').on("change paste keyup", function () {
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        switchValid(this, re.test($(this).val()));
    });

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

function registerUser() {
    var user = {};
    user["username"] = $("#login").val();
    user["email"] = $("#email").val();
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
                    window.location.href = 'home.html';
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
            if ($('.main-login').find('.valid').length === 4) {
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