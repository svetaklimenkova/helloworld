$(document).ready(function () {
    getTrainingById();
});

function getTrainingById() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/rest/trainings/" + window.location.href.match(/([^\/]*)\/*$/)[1],
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log(data);
            if (data !== null) {
                showTraining(data);
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function showTraining(training) {
    $('#id').val(training.id);
    $('#title').val(training.title);
    $('#description').val(training.description);
    $('#for-whom').val(training.forWhom);
    $('#goal').val(training.goal);

    getCategories($('#category').text(training.category));


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