$(document).ready(function () {
    getTrainingById();

    $('#back').click(function () {
        window.location.href = "/user/trainings"
    });

    $('#delete-user-training').click(function () {
        $.ajax({
            type: "DELETE",
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
        url: "/rest/user/trainings/" + window.location.href.match(/([^\/]*)\/*$/)[1],
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
            '<div class="stage-name">' + stage.index + '. ' + stage.name;
        if (stage.statusId === 3) {
            stageDiv += '<span class="glyphicon glyphicon-ok"></span>';
        }
        stageDiv += '</div><div class="tasks row">';
        stage.tasks.forEach(function (task) {
            var statusGlyphicon = "glyphicon-record";
            if (task.statusId === 3) {
                statusGlyphicon = "glyphicon-ok";
            }
            stageDiv += '<div class="task col-xs-12 row">' +
                '<input class="task-id" type="hidden" value="' + task.id + '">' +
                '<span class="glyphicon ' + statusGlyphicon + '"></span>' +
                task.name;
            if (task.statusId !== 0) {
                stageDiv += '<div class="task-span float-right button button-small">' +
                    '<button><span class="glyphicon glyphicon-option-horizontal"></span></button></div></div>';
                stageDiv += '<div class="row col-xs-12 reports starthidden">';

                task.reports.forEach(function (report) {
                    var icon = "";
                    if (report.statusId === 1) {
                        icon = 'glyphicon glyphicon-time';
                    } else if (report.statusId === 2) {
                        icon = 'glyphicon glyphicon-ok';
                    } else if (report.statusId === 3) {
                        icon = 'glyphicon glyphicon-remove';
                    }
                    stageDiv += '<div class="report col-xs-12 row"><div class="col-xs-3">' +
                        report.id + '</div><div class="col-xs-8">' + report.message + '</div>' +
                        '<div class="col-xs-1"><span class="' + icon + '"></span></div></div>';
                });

                if (task.statusId !== 3) {
                    stageDiv += '<div class="report col-xs-12 row"><div class="col-xs-11">' +
                        '<textarea maxlength="1000"></textarea></div><div class="float-right button button-small">' +
                        '<button class="send"><span class="glyphicon glyphicon-send"></span></button></div></div>';
                }

                stageDiv += '</div>';
            } else {
                stageDiv += '</div>';
            }
        });
        stageDiv += '</div></div>';
        $('.stages').append(stageDiv);
    });

    $('.task-span button').click(function () {
        var p = $(this).parent().parent().next('.starthidden');
        $(p).slideToggle(500);
    });

    $('.send').click(function () {
        var textarea = $(this).parent().parent().find('textarea');
        var text = $(this).parent().parent().find('textarea').val();
        var taskId = $(this).parent().parent().parent().prev('.task').find('.task-id').val();
        $.ajax({
            type: "POST",
            contentType: "application/json",
            data: text,
            url: "/rest/trainings/" + window.location.href.match(/([^\/]*)\/*$/)[1] + "/tasks/" + taskId + '/reports',
            success: function (data) {
                if (data) {
                    $(textarea).val("");
                    //showMessage(data.message);
                }
            },
            error: function (e) {
                throwMessage(e.responseJSON.message);
            }
        });
    });
}