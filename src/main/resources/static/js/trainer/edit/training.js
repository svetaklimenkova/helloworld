$(document).ready(function () {
    getTrainingById();

    $('#cancel').click(function () {
        window.location.href = '/trainings/' + window.location.href.match(/([^\/]*)\/*$/)[1];
    });

    $('#ok').click(function () {
        editTraining();
    });

    $('.edit-tasks').on("change paste keyup", '.edit-task', function () {
        if ($(this).find('.task').val() !== "") {
            if ($(this).next('.edit-task').length === 0) {
                var li = $(this).clone(true);
                li.find('.task-id').val(null);
                li.find('.task').val("");
                $(this).after(li);
            }
        } else {
            while ($(this).next('.edit-task').length !== 0
            && $(this).next('.edit-task').find('.task').val() === "") {
                $(this).next('div.edit-task').remove();
            }
        }
    });

    $('.edit-stages').on("change paste keyup", '.stage', function () {
        if ($(this).val() !== "") {
            if ($(this).parent().next('.edit-stage').length === 0) {
                var li = $(this).parent().clone(true);

                li.children().val("");
                while(li.find('.edit-task').length !== 1) {
                    li.find('.edit-task')[0].remove();
                }

                li.find('.stage-id').val(-1);
                li.find('.task').val("");
                $(this).parent().after(li);
            }
        } else {
            while ($(this).parent().next('.edit-stage').length !== 0
            && $(this).parent().next('.edit-stage').find('.stage').val() === "") {
                if ($(this).parent().next('.edit-stage').find('.task').length === 1) {
                    $(this).parent().next('.edit-stage').remove();
                } else {
                    break;
                }
            }
        }
        recountStageIndex();
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
    $('#title').val(training.title);
    $('#description').val(training.description);
    $('#for-whom').val(training.forWhom);
    $('#goal').val(training.goal);
    $('#participants').val(training.maxParticipants);

    getCategories($('#category').text(training.category));

    showStages(training.stages);

}

function showStages(stages) {
    for (var i = 0; i < stages.length; i++) {
        $('.edit-stages').append($($('.edit-stage')[0]).clone(true));
    }

    var stageNum = 0;
    $('.edit-stages').children().each(function () {
        if (stageNum >= stages.length) {
            return false;
        }

        $(this).find('.stage-id').val(stages[stageNum].id);
        $(this).find('.stage-index').text(stages[stageNum].index);
        $(this).find('.stage').val(stages[stageNum].name);

        var tasks = stages[stageNum].tasks;

        for (var i = 0; i < tasks.length; i++) {
            $(this).find('.edit-tasks').append($($(this).find('.edit-task')[0]).clone(true));
        }

        var taskNum = 0;
        $(this).find('.edit-task').each(function () {
            if (taskNum >= tasks.length) {
                return false;
            }

            $(this).find('.task-id').val(tasks[taskNum].id);
            $(this).find('.task').val(tasks[taskNum].name);
            taskNum++;
        });

        stageNum++;
    });
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

function recountStageIndex() {
    var stageNum = 0;
    $('.edit-stages').children().each(function () {
        $(this).find('.stage-index').text(++stageNum);
    });
}

function editTraining() {
    var training = {};

    training["id"] = $("#id").val();
    training["title"] = $("#title").val();
    training["description"] = $("#description").val();
    training["forWhom"] = $('#for-whom').val();
    training["goal"] = $('#goal').val();
    training["maxParticipants"] = $('#participants').val();

    training["category"] = $('#categories').val();

    var stages = [];
    var stageItems = $('.edit-stages');
    var countStages = 0;

    $.each(stageItems[0].children, function (key, value) {
        if ($(value).find('.stage').val() !== "") {
            var stage = {};

            stage['id'] = $(value).find('.stage-id').val();
            stage['name'] = $(value).find('.stage').val();
            stage['index'] = countStages + 1;

            var tasks = [];
            var countTasks = 0;

            $.each($(value).find('.edit-task'), function (key, value) {
                if ($(value).find('.task').val() !== "") {
                    var task = {};
                    task['id'] = $(value).find('.task-id').val();
                    task['name'] = $(value).find('.task').val();
                    tasks[countTasks] = task;
                    countTasks++;
                }
            });

            stage['tasks'] = tasks;
            stages[countStages] = stage;
            countStages++;
        }
    });

    training['stages'] = stages;
    console.log(training);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: '/rest/trainings/' + training.id,
        data: JSON.stringify(training),
        dataType: 'json',
        success: function (data) {
            if (data !== null) {
                window.location.href = '/trainings/' + training.id;
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}
