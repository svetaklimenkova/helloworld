<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title><spring:message code="main.title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="/static/icon.png" type="image/png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-theme.css">

    <!-- Project CSS -->
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/navbar.css">
    <link rel="stylesheet" type="text/css" href="/css/form.css">

    <!-- Font -->
    <link href="/fonts/caveat.css" rel="stylesheet">
</head>
<body>

<c:import url="preloader.jsp"/>

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
                    <h4><spring:message code="form.sign_up"/></h4>

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
                        <input type="email" name="email" id="mail" maxlength="254"/>
                        <span class="spin"></span>
                        <span class="input-group-addon invalid input-check">
                            <i class="glyphicon glyphicon-remove" data-toggle="tooltip" data-placement="auto right"
                               title="<spring:message code="form.mail.empty"/>"></i>
                            <input id="mail-size" type="hidden" value="<spring:message code="form.mail.size"/>">
                            <input id="mail-empty" type="hidden" value="<spring:message code="form.mail.empty"/>">
                            <input id="mail-exist" type="hidden" value="<spring:message code="form.mail.existed"/>">
                            <input id="mail-invalid" type="hidden" value="<spring:message code="form.mail.invalid"/>">
                        </span>
                    </div>

                    <div class="input">
                        <label for="password"><spring:message code="form.password"/></label>
                        <input type="password" name="password" id="password" maxlength="20"/>
                        <span class="spin"></span>
                        <span class="input-group-addon invalid input-check">
                            <i class="glyphicon glyphicon-remove" data-toggle="tooltip" data-placement="auto right"
                               title="<spring:message code="form.password.size"/>"></i>
                        </span>
                    </div>

                    <div class="input">
                        <label for="confirm"><spring:message code="form.confirm_password"/></label>
                        <input type="password" name="confirm" id="confirm" maxlength="20"/>
                        <span class="spin"></span>
                        <span class="input-group-addon invalid input-check">
                            <i class="glyphicon glyphicon-remove" data-toggle="tooltip" data-placement="auto right"
                               title="<spring:message code="form.confirm_password.incorrect"/>"></i>
                        </span>
                    </div>

                    <div class="button login">
                        <button type="button" disabled="true" id="btn_sign_up"><spring:message code="form.sign_up"/></button>
                    </div>
                </form>
            </div>

            <div class="clearfix"></div>
            <div class="myclearfix col-sm-12"></div>

        </div>
    </div>
</main>

<jsp:include page="footer.jsp" />

<script src="/js/com/form.js"></script>
<script src="/js/signUp.js"></script>

</body>
</html>