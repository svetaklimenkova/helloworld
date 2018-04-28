<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
    <link rel="stylesheet" type="text/css" href="/css/mylist.css">

    <!-- Font -->
    <link href="/fonts/caveat.css" rel="stylesheet">
</head>
<body>
<!-- Navigation Bar -->
<header>
    <nav class="navbar mynav">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    <spring:message code="main.brand"/>
                </a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <spring:message code="main.language"/>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="?lang=ru">RU</a></li>
                        <li><a href="?lang=en">EN</a></li>
                    </ul>
                </li>
                <li><a id="username"></a></li>
                <li><a href="/logout"><spring:message code="main.exit"/></a></li>
            </ul>
        </div>
    </nav>
</header>

<main>
    <div class="container">
        <div class="row">
            <div class="navi col-xs-12 col-sm-6 col-md-4 col-lg-3">
                <ul>
                    <li class="active">
                        <a href="/trainings">
                            <span><spring:message code="trainings.mine"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="/users">
                            <span><spring:message code="trainings.participants"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="/reports">
                            <span><spring:message code="reports.many"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="/profile">
                            <span><spring:message code="profile.mine"/></span>
                        </a>
                    </li>
                </ul>
            </div>

            <div id='content' class="content col-xs-12 col-sm-6 col-md-8 col-lg-9">
                <div class="row">
                    <div class="col-xs-12 title">
                        <div class="title-back">
                            <a class="title-back" href="/trainings">
                                <spring:message code="main.back"/>
                            </a>
                        </div>
                        <div class="title-text"><spring:message code="trainings.editing"/></div>
                        <div class="button button-small">
                            <button class="glyphicon glyphicon-remove-sign" id="cancel" type="button"></button>
                        </div>
                        <div class="button button-small">
                            <button class="glyphicon glyphicon-ok-sign" id="ok" type="button"></button>
                        </div>
                    </div>

                    <input id="id" type="hidden">

                    <div class="input">
                        <label for="title"><spring:message code="trainings.title"/></label>
                        <input type="text" name="title" maxlength="52" id="title"/>
                        <span class="spin"></span>
                    </div>

                    <div class="input">
                        <label for="for-whom"><spring:message code="trainings.for_whom"/></label>
                        <input type="text" name="for-whom" maxlength="255" id="for-whom"/>
                        <span class="spin"></span>
                    </div>

                    <div class="input">
                        <label for="goal"><spring:message code="trainings.goal"/></label>
                        <input type="text" name="goal" maxlength="255" id="goal"/>
                        <span class="spin"></span>
                    </div>

                    <div class="input">
                        <label for="description"><spring:message code="trainings.description"/></label>
                        <input type="text" name="description" maxlength="255" id="description"/>
                        <span class="spin"></span>
                    </div>
                </div>
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

<div class='error_box'>
    <p id='error_message'>Error</p>
</div>

<script src="/js/fr/jquery-3.3.1.min.js"></script>
<script src="/js/fr/bootstrap.min.js"></script>

<script src="/js/com/username.js"></script>

<script src="/js/trainer/edit/training.js"></script>
<script src="/js/com/error_message.js"></script>
</body>
</html>