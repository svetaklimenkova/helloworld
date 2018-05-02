$(document).ready(function () {
    getTrainingById();

    $('#add-user-training').click(function () {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/rest/trainings/" + window.location.href.match(/([^\/]*)\/*$/)[1] + "/user",
            cache: false,
            timeout: 600000,
            success: function (data) {
                if (data) {
                    showMessage(data.message);
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
    $('#participants').text(training.participantsCount + "/" + training.maxParticipants);

    training.stages.forEach(function(stage) {
        var stageDiv = '<div class="stage col-xs-12">' +
            '<div class="stage-name">' + stage.index + '. ' + stage.name + '</div>' +
            '<div class="tasks row">';
        stage.tasks.forEach(function (task) {
            stageDiv += '<div class="task col-xs-12">' +
                '<span class="glyphicon glyphicon-record"></span>' +
                task.name +
                '</div>';
        });
        stageDiv += '</div></div>';
        $('.stages').append(stageDiv);
    });
}