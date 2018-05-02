$(document).ready(function () {
    getCategories("");
    getTrainings(0, "");
    $('#page').click(function () {
        getTrainings(-1, $('#search').val(), $('#is-show-search').val() === 'y');
    });
    $('#search').on("change paste keyup", function () {
        if($('#is-show-search').val() === 'n') {
            getTrainings(0, $(this).val(), false);
        }
    });

    $('#adv-search').on("click", function () {
        getTrainings(0, $('#search').val(), true);
    });

    $('#show-search').on("click", function () {
        if($('#is-show-search').val() === 'n') {
            $('#categories').parent().slideDown(500);
            $('#trainer').parent().slideDown(500);
            $('#for-whom').parent().slideDown(500);
            $('#goal').parent().slideDown(500);
            $('#open').parent().slideDown(500);
            $('#adv-search').parent().slideDown(500);
            $('#is-show-search').val('y');
        } else {
            $('#categories').parent().slideUp(500);
            $('#trainer').parent().slideUp(500);
            $('#for-whom').parent().slideUp(500);
            $('#goal').parent().slideUp(500);
            $('#open').parent().slideUp(500);
            $('#adv-search').parent().slideUp(500);
            $('#is-show-search').val('n');
        }
    });
});

function getTrainings(page, title, advanced) {
    $('#page').show();
    var size = 6;
    if (page === -1) {
        page = Math.round($('#result').children('div').length / size);
    }
    var data = {};
    data['title'] = title;
    data['page'] = page;
    data['size'] = size;
    if (advanced) {
        if ($('#categories').val() !== "---") {
            data['category.categoryName'] = $('#categories').val();
        }
        data['forWhom'] = $('#for-whom').val();
        data['goal'] = $('#goal').val();
        data['user.username'] = $('#trainer').val();
        data['isOpen'] = $('#open').prop('checked');
    }
    $.ajax({
        type: "GET",
        url: "/rest/trainings",
        data: data,
        contentType: "application/json",
        success: function (data) {
            if(data) {
                showTrainings(data, page);
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

function showTrainings(trainings, page) {
    if (page === 0) {
        $('#result').find('div').remove();
    }

    for (var i = 0; i < trainings.length; i++) {
        $('#result').append(
            '<div class="col-sm-12 col-md-6"><div class="block"> ' +
                '<a href="/trainings/' + trainings[i].id + '">' +
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

function getCategories(selected) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/rest/categories/",
        dataType: 'json',
        success: function (data) {
            console.log(data);
            if (data !== null) {
                showCategories(data, selected);
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function showCategories(categories, selected) {
    categories.forEach(function (item) {
        if (item.categoryName === selected) {
            $('#categories').append('<option selected>' + item.categoryName + '</option>');
        } else {
            $('#categories').append('<option>' + item.categoryName + '</option>');
        }
    });
}

