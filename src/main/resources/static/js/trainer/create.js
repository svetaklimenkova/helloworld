$(document).ready(function () {
    $('#cancel').click(function () {
        window.location.href = '/trainings/' + training.id;
    });

    $('#ok').click(function () {
        createTraining();
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

    getCategories("");
});

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

function createTraining() {
    var training = {};

    training["title"] = $("#title").val();
    training["description"] = $("#description").val();
    training["forWhom"] = $('#for-whom').val();
    training["goal"] = $('#goal').val();
    training["maxParticipants"] = $('#participants').val();

    training["category"] = $('#categories').val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: '/rest/trainings/',
        data: JSON.stringify(training),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            if (data !== null) {
                createStages(data);
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });

}

function createStages(training) {
    var stages = [];
    var stageItems = $('.edit-stages');
    var countStages = 0;

    $.each(stageItems[0].children, function (key, value) {
        if ($(value).find('.stage').val() !== "") {
            var stage = {};

            stage['id'] = $(value).find('.stage-id').val();
            stage['name'] = $(value).find('.stage').val();
            stage['index'] = $(value).find('.stage-index').text();

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

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: '/rest/trainings/',
        data: JSON.stringify(training),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            if (data !== null) {
                window.location.href = '/trainings/';
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}