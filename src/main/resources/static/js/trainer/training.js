$(document).ready(function () {
    getTrainingById();

    $('#edit').click(function () {
        window.location.href = "/trainings/edit/" + window.location.href.match(/([^\/]*)\/*$/)[1];
    });
    $('#delete').click(function () {
        $.ajax({
            type: "DELETE",
            contentType: "application/json",
            url: "/rest/trainings/" + window.location.href.match(/([^\/]*)\/*$/)[1],
            cache: false,
            timeout: 600000,
            success: function (data) {
                if (data) {
                    window.location.href = "/trainings";
                }
            },
            error: function (e) {
                throwMessage(e.responseJSON.message);
            }
        });
    });
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
    $('#title').text(training.title);
    $('#description').text(training.description);
    $('#category').text(training.category);
    $('#for-whom').text(training.forWhom);
    $('#goal').text(training.goal);
    $('#trainer').text(training.userName);
}