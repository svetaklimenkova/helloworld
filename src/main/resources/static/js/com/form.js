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