$(document).ready(function () {
    getCategoryList("");

    $('#add').click(function () {
    })
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
    var options = {
        valueNames: ['categoryName'],
        // Since there are no elements in the list, this will be used as template.
        item: '<li><div class=" row my-list-item row user-info">' +
        '<div class="categoryName col-xs-10"></div>' +
        '</div></li>'
    };

    var userList = new List('content', options, categories);
}
