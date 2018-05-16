$(document).ready(function () {
    getReports(0, "");
    $('#page').click(function () {
        getReports(-1);
    });
});

function getReports(page) {
    $('#page').show();
    var size = 6;
    if (page === -1) {
        page = Math.round($('#result').children('div').length / size);
    }
    var data = {};
    data['page'] = page;
    data['size'] = size;
    $.ajax({
        type: "GET",
        url: "/rest/user/reports",
        data: data,
        contentType: "application/json",
        success: function (data) {
            if(data) {
                showReports(data, page);
                if (data.length < size) {
                    $('#page').hide();
                }
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function showReports(reports, page) {
    if (page === 0) {
        $('#result').find('div').remove();
    }

    for (var i = 0; i < reports.length; i++) {
        var icon = "";
        if (reports[i].statusId === 1) {
            icon = 'glyphicon glyphicon-time';
        } else if (reports[i].statusId === 2) {
            icon = 'glyphicon glyphicon-ok';
        } else if (reports[i].statusId === 3) {
            icon = 'glyphicon glyphicon-remove';
        }

        $('#result').append(
            '<div class="col-sm-12 report"><div class="report-min"> ' +
            '<div class="status col-xs-1"><span class="' + icon + '"></span></div>' +
            '<div class="id col-xs-2">' + reports[i].id + '</div>' +
            '<div class="from col-xs-2">' + reports[i].from + '</div>' +
            '<div class="training col-xs-2">' + reports[i].training + '</div>' +
            '<div class="task col-xs-3">' + reports[i].task + '</div>' +
            '<div class="date col-xs-2">' + new Date(reports[i].createdBy).toLocaleDateString() + '</div>' +
            '</div>' +
            '<div class="starthidden">' + reports[i].message + '</div>' +
            '</div>');
    }

    $('.report-min').click(function () {
        $(this).next('.starthidden').slideToggle(500);
    })
}