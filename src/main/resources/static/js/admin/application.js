$(document).ready(function () {
    getApplicationById();

    $('#accept').click(function () {
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
                    $("#accept").hide();
                    $("#reject").hide();
                }
            },
            error: function (e) {
                console.log(e.toString());
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
            console.log(e.toString());
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
    $('#status').text(application.status);

    if (application.status === "IN_PROGRESS") {
        $("#delete").hide();
    } else {
        $("#accept").hide();
        $("#reject").hide();
    }
}
