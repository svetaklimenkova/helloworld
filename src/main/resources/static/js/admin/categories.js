$(document).ready(function () {
    getCategoryList("");

    $('#add').click(function () {
        var data = {};
        var name = $('#category').val();
        if (name !== "") {
            data['name'] = name;
        }
        $.ajax({
            type: "POST",
            url: "/rest/categories",
            data: name,
            contentType: "application/json",
            success: function (data) {
                if(data) {
                    showMessage($('#category_added').val());
                    getCategoryList(name);
                }
            },
            error: function (e) {
                throwMessage(e.responseJSON.message);
            }
        });
    });

    $('#category').on("change paste keyup", function () {
        var elem = $(this);
        getCategoryList(elem.val());
    });
});

function getCategoryList(name) {
    var data = {};
    if (name !== "") {
        data['name'] = name;
    }
    $.ajax({
        type: "GET",
        url: "/rest/categories",
        data: data,
        contentType: "application/json",
        success: function (data) {
            if(data) {
                showCategoryList(data);
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function showCategoryList(categories) {
    $('.list').find('li').remove();

    for (var i = 0; i < categories.length; i++) {
        $('.list').append(
            '<li><div class=" row my-list-item user-info">' +
                '<input class="action" type="hidden">' +
                '<input class="id" type="hidden" value="' + categories[i].categoryId + '">' +
                '<div class="input starthidden">' +
                    '<input class="new-category" value="'+ categories[i].categoryName +'">' +
                '</div>' +
                '<div class="category float-left">' +  categories[i].categoryName + '</div>' +
                '<div class="button button-small float-right">' +
                    '<button class="glyphicon glyphicon-trash small btn-delete" type="button"></button>' +
                '</div>' +
                '<div class="button button-small float-right">' +
                    '<button class="glyphicon glyphicon-edit small btn-edit" type="button"></button>' +
                '</div>' +

                '<div class="button button-small float-right starthidden">' +
                '<button class="glyphicon glyphicon-ok-sign small btn-ok" type="button"></button>' +
                '</div>' +
                '<div class="button button-small float-right starthidden">' +
                '<button class="glyphicon glyphicon-remove-sign small btn-cancel" type="button"></button>' +
                '</div>' +
                '</div></li>'
        );
    }
    $($('.list')).find('.btn-edit').click(function () {
        var parentDiv = $(this).parent().parent();
        parentDiv.find('.action').val('edit')
        parentDiv.find('.new-category').val(parentDiv.find('.category').text());;
        parentDiv.find('.category').hide();
        parentDiv.find('.button').hide();
        parentDiv.find('.starthidden').show();
    });
    $($('.list')).find('.btn-delete').click(function () {
        var parentDiv = $(this).parent().parent();
        parentDiv.find('.action').val('delete');
        parentDiv.find('.new-category').val($('#category_really_delete').val());
        parentDiv.find('.new-category').attr('disabled', true);
        parentDiv.find('.category').hide();
        parentDiv.find('.button').hide();
        parentDiv.find('.starthidden').show();
    });
    $($('.list')).find('.btn-cancel').click(function () {
        var parentDiv = $(this).parent().parent();
        parentDiv.find('.new-category').attr('disabled', false);
        parentDiv.find('.category').show();
        parentDiv.find('.button').show();
        parentDiv.find('.starthidden').hide();
    });
    $($('.list')).find('.btn-ok').click(function () {
        var parentDiv = $(this).parent().parent();
        if (parentDiv.find('.action').val() === 'edit') {
            var newName = parentDiv.find('.new-category').val();
            if (newName === "") {
                throwMessage($('#category_empty').val());
                return;
            }
            $.ajax({
                type: "POST",
                url: "/rest/categories/" + parentDiv.find('.id').val(),
                data: newName,
                contentType: "application/json",
                success: function (data) {
                    if (data) {
                        showMessage($('#category_updated').val());
                        parentDiv.find('.category').text(data.categoryName);
                        parentDiv.find('.category').show();
                        parentDiv.find('.button').show();
                        parentDiv.find('.starthidden').hide();
                    }
                },
                error: function (e) {
                    throwMessage(e.responseJSON.message);
                }
            });
        } else {
            $.ajax({
                type: "DELETE",
                url: "/rest/categories/" + parentDiv.find('.id').val(),
                success: function (data) {
                    showMessage($('#category_deleted').val());
                    parentDiv.parent().remove();
                },
                error: function (e) {
                    throwMessage(e.responseJSON.message);
                }
            });
        }
    });
}
