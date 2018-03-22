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