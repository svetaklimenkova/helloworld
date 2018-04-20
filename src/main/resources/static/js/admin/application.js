$(document).ready(function () {
    getApplicationById();

    $('#accept').click(function () {
        if ($('#accept').hasClass('active')) {
            return;
        }
        var dto = {};
        dto.status = "ACCEPTED";

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/rest/applications/" + $('#id').val(),
            data: JSON.stringify(dto),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                if (data !== null) {
                    $("#delete").show();
                    $("#accept").addClass("active");
                    $("#reject").hide();
                }
            },
            error: function (e) {
                throwMessage(e.responseJSON.message);
            }
        });
    });

    $('#reject').click(function () {
        if ($('#reject').hasClass('active')) {
            return;
        }
        var dto = {};
        dto.status = "REJECTED";

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/rest/applications/" + $('#id').val(),
            data: JSON.stringify(dto),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                if (data !== null) {
                    $("#delete").show();
                    $("#accept").hide();
                    $("#reject").addClass("active");
                }
            },
            error: function (e) {
                throwMessage(e.responseJSON.message);
            }
        });
    });

    $('#delete').click(function () {
        $.ajax({
            type: "DELETE",
            contentType: "application/json",
            url: "/rest/applications/" + $('#id').val(),
            cache: false,
            timeout: 600000,
            success: function (data) {
                if (data) {
                    window.location.href = "/applications";
                }
            },
            error: function (e) {
                throwMessage(e.responseJSON.message);
            }
        });
    });
});

function getApplicationById() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/rest/applications/" + $('#id').val(),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log(data);
            if (data !== null) {
                showApplication(data);
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function showApplication(application) {
    $('#type').text(application.type);
    $('#createdBy').text(new Date(application.createdBy).toLocaleDateString());
    $('#updatedBy').text(new Date(application.updatedBy).toLocaleDateString());
    $('#mail').text(application.mailOfReceiver);
    $('#description').text(application.description);
    $('#receiver').text(application.receiver);

    if (application.status === "IN_PROGRESS") {
        $("#delete").hide();
    } else if (application.status === "ACCEPTED") {
        $("#accept").addClass("active");
        $("#reject").hide();
    } else if (application.status === "REJECTED") {
        $("#accept").hide();
        $("#reject").addClass("active");
    }
}