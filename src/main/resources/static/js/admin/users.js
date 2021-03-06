$(document).ready(function () {
    showUserList(getUserList());
});

function getUserList() {
    var users = null;
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/rest/users",
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
        valueNames: [ 'role', 'username', "mail" ],
        // Since there are no elements in the list, this will be used as template.
        item: '<li><div class=" row my-list-item row user-info"><div class="role col-xs-3 "></div>' +
        '<div class="username col-xs-4"></div>\<' +
        'div class="mail col-xs-5"></div>' +
        '</div></li>\''
    };

    var userList = new List('content', options, users);
}
