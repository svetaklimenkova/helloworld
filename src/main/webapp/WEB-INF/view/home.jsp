<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><spring:message code="message.brand"/> </title>
    <link rel="shortcut icon" href="/static/icon.png" type="image/png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <!-- Project CSS -->
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/navbar.css">
    <link rel="stylesheet" type="text/css" href="/css/login_form.css">

    <!-- Font -->
    <link href="https://fonts.googleapis.com/css?family=Caveat" rel="stylesheet">
</head>
<body>
<div class="container">
    <!-- Navigation Bar -->
    <header>
        <nav class="navbar mynav">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        <spring:message code="message.brand"/>
                    </a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdo wn">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <spring:message code="message.language"/>
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="?lang=ru">RU</a></li>
                            <li><a href="?lang=en">EN</a></li>
                        </ul>
                    </li>
                    <li><a href="/signUp"><span class="glyphicon glyphicon-user"></span>
                        <spring:message code="message.sign_up"/>
                    </a></li>
                </ul>
            </div>
        </nav>
    </header>

    <!-- Main Block -->
    <div id="main">
        <div class="col-xs-12 col-sm-6 col-md-8 col-lg-9">
            <h1><br><br>
                <spring:message code="message.brand_text"/>
            </h1>
        </div>
        <div class="login-form col-xs-12 col-sm-6 col-md-4 col-lg-3">
            <div class="row">
                <div class="form-login login-container">
                    <form action="j_spring_security_check" method="post">

                        <h4><spring:message code="message.welcome_back"/></h4>

                        <div class="input">
                            <label for="username"><spring:message code="message.username"/></label>
                            <input name="username" type="text" id="username" maxlength="255"/>
                            <span class="spin"></span>
                        </div>

                        <div class="input">
                            <label for="password"><spring:message code="message.password"/></label>
                            <input name="password" type="password" id="password" maxlength="20"/>
                            <span class="spin"></span>
                        </div>

                        <h5 id="error" style="display: none"><spring:message code="message.error.invalid_username_or_password"/></h5>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        <div class="button login">
                            <button type="submit"><spring:message code="message.sign_in"/></button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="particles"></div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

<script src="/js/home.js"></script>
</body>
</html>