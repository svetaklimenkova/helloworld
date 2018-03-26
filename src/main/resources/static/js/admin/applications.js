$(document).ready(function () {
    getApplications();
});

function getApplications() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/rest/applications",
        cache: false,
        timeout: 600000,
        dataType: "json",
        success: function (data) {
            if(data) {
                showApplications(data);
            }
        },
        error: function (e) {
            console.log(JSON.stringify(e.responseText));
            return false;
        }
    });
}

function showApplications(applications) {
    var options = {
        valueNames: [
            'id',
            'type',
            "mailOfReceiver",
            { attr: 'name', name: 'status' },
            "updatedBy",
            { attr: 'href', name: 'link' }],
        // Since there are no elements in the list, this will be used as template.
        item: '<li><div><a class="link application-info my-list-item row">' +
            '<div class="status col-xs-1"><span><i class="glyphicon"></i></span></div>' +
            '<div class="id col-xs-2"></div>' +
            '<div class="type col-xs-3"></div>' +
            '<div class="mailOfReceiver col-xs-3"></div>' +
            '<div class="updatedBy col-xs-3"></div>' +
        '</a></div></li>'
    };

    for (var i = 0; i < applications.length; i++) {
        applications[i].link = "/applications/" + applications[i].id;
        applications[i].updatedBy = new Date(applications[i].updatedBy).toLocaleDateString();
    }

    var userList = new List('content', options, applications);

    $.each($('.list').find('.status'), function () {
        if ($(this).attr("name") === "IN_PROGRESS") {
            $(this).find("span").addClass("valid");
            $(this).find("i").addClass("glyphicon glyphicon-pencil");
        } else if ($(this).attr("name") === "ACCEPTED") {
            $(this).find("span").addClass("valid");
            $(this).find("i").addClass("glyphicon glyphicon-ok");
        } else if ($(this).attr("name") === "REJECTED") {
            $(this).find("span").addClass("invalid");
            $(this).find("i").addClass("glyphicon glyphicon-remove");
        }
    });
}
