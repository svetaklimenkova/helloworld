$(document).ready(function () {
    var result = getUrlVar();

    if (result['error'] === "true") {
        $('#error').css('display', 'block');
    }

    $('#username').delay(1000).trigger('click');

    setCatImg();
    $("#refresh").click(function () {
        setCatImg();
        PetrPro.init();
        PetrPro.add("PetrPro.quote('myQuoteTag')");
    });

    PetrPro.init();
    PetrPro.add("PetrPro.quote('myQuoteTag')");

});

function setCatImg() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "https://aws.random.cat/meow",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            if (data !== null) {
                $("#random_cat").attr("src", data.file);
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function getUrlVar(){
    var urlVar = window.location.search;
    var valueAndKey = [];
    var resultArray = [];
    arrayVar = (urlVar.substr(1)).split('&');
    if(arrayVar[0] === "") return [];
    for (i = 0; i < arrayVar.length; i ++) {
        valueAndKey = arrayVar[i].split('=');
        resultArray[valueAndKey[0]] = valueAndKey[1];
    }
    return resultArray;
}