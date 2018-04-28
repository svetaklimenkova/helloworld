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
    $('#category').text(training.category);
    $('#for-whom').vl(training.forWhom);
    $('#goal').val(training.goal);
    $('#trainer').text(training.userName);
}