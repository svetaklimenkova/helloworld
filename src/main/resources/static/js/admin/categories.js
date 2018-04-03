$(document).ready(function () {
    var username = getUsername();
    $('#username').text(username);

    showUserList(getCategoryList());
});

function getUsername() {
    var username = "";
    $.ajax({
        type: "GET",
        url: "/rest/username",
        cache: false,
        timeout: 600000,
        dataType: "text",
        async: false,
        success: function (data) {
            if(data) {
                username = data;
            }
        },
        error: function (e) {
            console.log(JSON.stringify(e.responseText));
            return false;
        }
    });
    return username;
}

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
        valueNames: [ 'id', 'name'],
        // Since there are no elements in the list, this will be used as template.
        item: '<li><div class=" row my-list-item row user-info">' +
        '<div class="id hidden-xs"></div>' +
        '<div class="name col-xs-10"></div>\<' +
        '</div></li>\''
    };

    var userList = new List('content', options, users);
}
