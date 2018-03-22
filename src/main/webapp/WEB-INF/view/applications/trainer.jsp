<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><spring:message code="main.brand"/></title>
    <link rel="shortcut icon" href="/static/icon.png" type="image/png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">

    <!-- Project CSS -->
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/navbar.css">
    <link rel="stylesheet" type="text/css" href="/css/form.css">

    <!-- Font -->
    <link href="/fonts/caveat.css" rel="stylesheet">
</head>
<body>
<header>
    <div class="container">
        <nav class="navbar mynav container-fluid">
            <div class="navbar-header">
                <a href="/home" class="navbar-brand brand-text">
                    <span class="glyphicon brand-image"></span>
                    <spring:message code="main.brand"/>
                </a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown">
                        <spring:message code="main.language"/>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="?lang=ru">RU</a></li>
                        <li><a href="?lang=en">EN</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</header>

<main>
    <div class="container">
        <div class="row">
            <div class="my-form col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-2 col-md-8">
                <form>
                    <a class="return" href="/home"><spring:message code="main.back"/></a>
                    <h4><spring:message code="main.be_trainer"/></h4>

                    <div class="input">
                        <label for="login"><spring:message code="form.username"/></label>
                        <input type="text" name="name" maxlength="254" id="login"/>
                        <span class="spin"></span>
                        <span class="input-group-addon invalid input-check">
                            <i class="glyphicon glyphicon-remove" data-toggle="tooltip" data-placement="auto right"
                               title="<spring:message code="form.username.empty"/>"></i>
                            <input id="login-size" type="hidden" value="<spring:message code="form.username.size"/>">
                            <input id="login-empty" type="hidden" value="<spring:message code="form.username.empty"/>">
                            <input id="login-exist" type="hidden" value="<spring:message code="form.username.existed"/>">
                            <input id="login-invalid" type="hidden" value="<spring:message code="form.username.invalid"/>">
                        </span>
                    </div>

                    <div class="input">
                    <label for="mail"><spring:message code="form.mail"/></label>
                    <input type="text" name="email" id="mail" maxlength="254"/>
                    <span class="spin"></span>
                    <span class="input-group-addon invalid input-check">
                            <i class="glyphicon glyphicon-remove" data-toggle="tooltip" data-placement="auto right"
                               title="<spring:message code="form.mail.empty"/>"></i>
                            <input id="mail-size" type="hidden" value="<spring:message code="form.mail.size"/>">
                            <input id="mail-empty" type="hidden" value="<spring:message code="form.mail.empty"/>">
                            <input id="mail-invalid" type="hidden" value="<spring:message code="form.mail.invalid"/>">
                        </span>
                    </div>

                    <div class="input">
                        <label for="message"><spring:message code="form.message.description"/></label>
                        <input type="text" name="message" id="message" maxlength="1000"/>
                        <span class="spin"></span>
                        <span class="input-group-addon invalid input-check">
                            <i class="glyphicon glyphicon-remove" data-toggle="tooltip" data-placement="auto right"
                               title="<spring:message code="form.mail.empty"/>"></i>
                            <input id="message-empty" type="hidden" value="<spring:message code="form.mail.empty"/>">
                            <input id="message-size" type="hidden" value="<spring:message code="form.mail.size"/>">
                        </span>
                    </div>

                    <div class="clearfix hidden-xs"></div>
                    <div align="center" class="message" style="display: none; color: indigo">
                        <spring:message code="form.application.accepted"/>
                    </div>

                    <div class="button login">
                        <button id="btn_sign_up" disabled type="button"><spring:message code="form.application.send"/></button>
                    </div>
                </form>
            </div>

            <div class="clearfix"></div>
            <div class="myclearfix col-sm-12"></div>

        </div>
    </div>
</main>

<footer>
    <div class="container">
        <div class="row">
            <div class="spin col-xs-12"></div>
            <div class="clearfix hidden-xs"></div>

            <div class="col-xs-12 col-sm-3 col-md-2">
                <spring:message code="main.support"/><br>
                svetaklimenkova@mail.ru<br>
                svetkaklimenkova98@gmail.com</div>
            <div class="col-xs-12 col-sm-4 col-md-3"></div>
            <div class="col-xs-12 col-sm-5 col-md-offset-3 col-md-4" style="text-align: end">
                © 2018 SLIVKI<br>
                <spring:message code="main.brand_text"/>
            </div>
        </div>
    </div>
</footer>

<div id="particles"></div>

<script src="/js/fr/jquery-3.3.1.min.js"></script>
<script src="/js/fr/bootstrap.min.js"></script>

<script src="/js/com/stars.js"></script>
<script src="/js/com/form.js"></script>
<script src="/js/com/form_checker.js"></script>

<script src="/js/trainer.js"></script>
</body>
</html>
