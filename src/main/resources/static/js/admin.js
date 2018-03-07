$(document).ready(function () {
    importContent();
    var username = getUsername();
    $('#username').text(username);
});

function importContent() {
    var content = document.querySelector('link[rel="import"]').import;
    var el = content.querySelector('.content');
    document.body.appendChild(el.cloneNode(true));
}

function getUsername() {
    var username = "";
    $.ajax({
        type: "GET",
        url: "/username",
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
