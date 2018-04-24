function throwMessage(str) {
    $('.error_box p').html(str);
    $(".error_box").fadeIn(500).delay(5000).fadeOut(500);
}

function showMessage(str) {
    $('.message_box p').html(str);
    $(".message_box").fadeIn(500).delay(5000).fadeOut(500);
}
