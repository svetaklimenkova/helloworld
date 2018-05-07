$(document).ready(function () {
    $(".input input, .input textarea").focus(function() {

        $(this).parent(".input").each(function() {
            $("label", this).css({
                "line-height": "20px",
                "font-size": "20px",
                "top": "0px"
            });
            $(".spin", this).css({
                "width": "100%"
            })
        });
    }).blur(function() {
        $(this).next(".spin").css({
            "width": "0px"
        });
        if ($(this).val() === "") {
            $(this).parent(".input").each(function() {
                $("label", this).css({
                    "line-height": "40px",
                    "font-size": "24px",
                    "top": "10px"
                })
            });
        }
    });

    $('[data-toggle="tooltip"]').tooltip();

    $("[data-toggle='tooltip']").on("mouseover", function () {
        if ($(this).parent().hasClass("invalid")) {
            $('.tooltip').addClass("tooltip-invalid").removeClass("tooltip-valid");
        } else if ($(this).parent().hasClass("valid")) {
            $(".tooltip").addClass("tooltip-valid").removeClass("tooltip-invalid").hide();
        } else {
            $(".tooltip").removeClass("tooltip-invalid tooltip-valid");
        }
    });
});

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
    $('#btn_sign_up').prop("disabled", true);
}

function switchValid(elem, result) {
    if (isEmpty(elem)) {
        return;
    }
    var spanCheck = $(elem).parent().find('.input-check');
    if (result) {
        if (spanCheck.hasClass('invalid')) {
            setValid(spanCheck);
            if ($('.my-form').find('.invalid').length === 0) {
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

function checkPassword() {
    $('#password').on("change paste keyup", function () {
        switchValid(this, $(this).val().length > 7);
        switchValid($('#confirm'), $('#confirm').val() === $('#password').val());
    });
}

function checkPasswordConfirm() {
    $('#confirm').on("change paste keyup", function () {
        switchValid(this, $(this).val() === $('#password').val());
        switchValid($('#password'), $('#password').val().length > 7);
    });
}

function checkUsername() {
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
            url: "/rest/users/valid?username=" + $(this).val(),
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

function checkMail() {
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
                switchValid(elem, data);
            },
            error: function (e) {
                console.log(JSON.stringify(e.responseText));
            }
        });
    });
}

function checkMessage() {
    $('#message').on("change paste keyup", function () {
        var elem = $(this);

        // empty login
        if(isEmpty($(this))) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#message-empty").val());
            return;
        }

        // invalid size
        if ($(this).val().length > 1000 || $(this).val().length < 10) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#message-size").val());
            switchValid(elem, false);
            return;
        }

        switchValid(elem, true);
    });
}
