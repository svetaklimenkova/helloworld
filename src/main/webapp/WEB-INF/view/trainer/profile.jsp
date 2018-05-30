<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<c:import url="../preloader.jsp"/>

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
                    <li>
                        <a href="/trainings">
                            <span><spring:message code="trainings.mine"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="/reports">
                            <span><spring:message code="reports.many"/></span>
                        </a>
                    </li>
                    <li class="active">
                        <a href="/profile">
                            <span><spring:message code="profile.mine"/></span>
                        </a>
                    </li>
                </ul>
            </div>

            <div id='content' class="content col-xs-12 col-sm-6 col-md-8 col-lg-9">
                <div class="row">
                    <div class="col-xs-12 title">
                        <div class="title-text"><spring:message code="profile.mine"/></div>
                        <div class="button button-small">
                            <button class="glyphicon glyphicon-remove-sign" id="back" type="button"></button>
                        </div>
                        <div class="button button-small">
                            <button class="glyphicon glyphicon-ok-circle" id="btn_sign_up" type="button"></button>
                        </div>
                    </div>

                    <div class="title-text-medium"><spring:message code="profile.change_mail"/></div>
                    <div class="col-xs-offset-1 col-xs-11">
                        <div class="input">
                            <label for="mail"><spring:message code="form.mail"/></label>
                            <input type="email" name="email" id="mail" maxlength="254"/>
                            <span class="spin"></span>
                            <span class="input-group-addon valid input-check">
                            <i class="glyphicon glyphicon-ok" data-toggle="tooltip" data-placement="auto right"
                               title="<spring:message code="form.mail.empty"/>"></i>
                            <input id="mail-size" type="hidden" value="<spring:message code="form.mail.size"/>">
                            <input id="mail-empty" type="hidden" value="<spring:message code="form.mail.empty"/>">
                            <input id="mail-exist" type="hidden" value="<spring:message code="form.mail.existed"/>">
                            <input id="mail-invalid" type="hidden" value="<spring:message code="form.mail.invalid"/>">
                        </span>
                        </div>
                    </div>

                    <div class="title-text-medium"><spring:message code="profile.change_password"/></div>
                    <div class="col-xs-offset-1 col-xs-11">

                    <div class="input">
                        <label for="password"><spring:message code="form.password"/></label>
                        <input type="password" name="password" id="password" maxlength="20"/>
                        <span class="spin"></span>
                        <span class="input-group-addon valid input-check">
                            <i class="glyphicon glyphicon-ok" data-toggle="tooltip" data-placement="auto right"
                               title="<spring:message code="form.password.size"/>"></i>
                        </span>
                    </div>

                    <div class="input">
                        <label for="confirm"><spring:message code="form.confirm_password"/></label>
                        <input type="password" name="confirm" id="confirm" maxlength="20"/>
                        <span class="spin"></span>
                        <span class="input-group-addon valid input-check">
                            <i class="glyphicon glyphicon-ok" data-toggle="tooltip" data-placement="auto right"
                               title="<spring:message code="form.confirm_password.incorrect"/>"></i>
                        </span>
                    </div>

                    </div>
                </div>
            </div>

            <div class="clearfix"></div>
            <div class="myclearfix col-sm-12"></div>

        </div>
    </div>
</main>
<input type="hidden" id="changes" value="<spring:message code="changes_save"/>">

<jsp:include page="../footer.jsp" />

<script src="/js/com/form.js"></script>
<script src="/js/user/profile.js"></script>

</body>
</html>