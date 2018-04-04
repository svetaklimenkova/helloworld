$(document).ready(function () {
    showUserList(getCategoryList());
});

function getCategoryList() {
    var users = null;
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/rest/categories",
        cache: false,
        timeout: 600000,
        dataType: "json",
        async: false,
        success: function (data) {
            if(data) {
                users = data
            }
        },
        error: function (e) {
            console.log(JSON.stringify(e.responseText));
            return false;
        }
    });
    return users;
}

function showUserList(users) {
    var options = {
        valueNames: [ 'categoryId', 'categoryName'],
        // Since there are no elements in the list, this will be used as template.
        item: '<li><div class=" row my-list-item row user-info">' +
        '<div class="categoryId hidden"></div>' +
        '<div class="categoryName col-xs-10"></div>' +
        '</div></li>\''
    };

    var userList = new List('content', options, users);
}
