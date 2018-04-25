$(document).ready(function () {
    getTrainings(0);
    $('#search').click(function () {
        getTrainings(-1);
    })
});

function getTrainings(page) {
    var size = 6;
    if (page === -1) {
        page = Math.round($('#result').children('div').length / size);
    }
    var data = {};
    data['page'] = page;
    data['size'] = size;
    $.ajax({
        type: "GET",
        url: "/rest/trainings",
        data: data,
        contentType: "application/json",
        success: function (data) {
            if(data) {
                showTrainings(data, page);
                if (data.length < size) {
                    $('#search').hide();
                }
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function showTrainings(trainings, page) {
    if (page === 0) {
        $('#result').find('div').remove();
    }

    for (var i = 0; i < trainings.length; i++) {
        $('#result').append(
            '<div class="col-sm-12 col-md-6"><div class="block"> ' +
                '<a href="trainings/' + trainings[i].id + '">' +
                '<div class="block-top" style="background: ' + getRandomColor() + '"></div></a>' +
                '<div class="block-sub-header">' + trainings[i].category + '</div>' +
                '<div class="block-header">' + trainings[i].title + '</div>' +
            '</div></div>');
    }
}

function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}