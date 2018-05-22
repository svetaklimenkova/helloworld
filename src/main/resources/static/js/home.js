$(document).ready(function () {
    var result = getUrlVar();

    if (result['error'] === "true") {
        $('#error').css('display', 'block');
    }

    $('#username').delay(1000).trigger('click');
});

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