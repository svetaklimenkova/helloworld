function checkPassword() {
    $('#password').on("change paste keyup", function () {
        switchValid(this, $(this).val().length > 7);
    });
}

function checkPasswordConfirm() {
    $('#confirm').on("change paste keyup", function () {
        switchValid(this, $(this).val() === $('#password').val());
    });
}

function checkUsername() {
    $('#login').on("change paste keyup", function () {
        var elem = $(this);

        // empty login
        if(isEmpty($(this))) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#login-empty").val());
            return;
        }
        // invalid symbols
        if (!/^[a-zA-Z0-9.-_]+$/.test($(this).val())) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#login-invalid").val());
            switchValid(elem, false);
            return;
        }

        // invalid size
        if ($(this).val().length > 32 || $(this).val().length < 4) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#login-size").val());
            switchValid(elem, false);
            return;
        }

        // existed username
        $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#login-exist").val());
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "valid?username=" + $(this).val(),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                switchValid(elem, data);
            },
            error: function (e) {
                console.log(JSON.stringify(e.responseText));
            }
        });
    });
}

function checkMail() {
    $('#mail').on("change paste keyup", function () {
        var elem = $(this);

        // empty login
        if(isEmpty($(this))) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#mail-empty").val());
            return;
        }

        // invalid size
        if ($(this).val().length > 255 || $(this).val().length < 5) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#mail-size").val());
            switchValid(elem, false);
            return;
        }

        // invalid symbols
        if (!/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test($(this).val())) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#mail-invalid").val());
            switchValid(elem, false);
            return;
        }

        // existed username
        $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#mail-exist").val());
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "valid?mail=" + $(this).val(),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                switchValid(elem, data);
            },
            error: function (e) {
                console.log(JSON.stringify(e.responseText));
            }
        });
    });
}

function checkMessage() {
    $('#message').on("change paste keyup", function () {
        var elem = $(this);

        // empty login
        if(isEmpty($(this))) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#message-empty").val());
            return;
        }

        // invalid size
        if ($(this).val().length > 1000 || $(this).val().length < 10) {
            $(this).parent().find('.input-check').find('i').attr("data-original-title", $("#message-size").val());
            switchValid(elem, false);
            return;
        }

        switchValid(elem, true);
    });
}
