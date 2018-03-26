$(document).ready(function () {
    var username = getUsername();
    $('#username').text(username);
});

function getUsername() {
    var username = "";
    $.ajax({
        type: "GET",
        url: "/users/username",
        cache: false,
        timeout: 600000,
        dataType: "text",
        async: false,
        success: function (data) {
            if(data) {
                username = data;
            }
        },
        error: function (e) {
            console.log(JSON.stringify(e.responseText));
            return false;
        }
    });
    return username;
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