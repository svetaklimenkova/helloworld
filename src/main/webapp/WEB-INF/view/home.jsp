<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <!-- Font -->
    <link href="/fonts/caveat.css" rel="stylesheet">
</head>

<c:import url="preloader.jsp"/>

<header>
    <div class="container">
        <nav class="navbar mynav container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand brand-text">
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
                <li><a href="/applications/trainer">
                    <spring:message code="main.be_trainer"/>
                </a></li>
                <li><a href="/signUp"><span class="glyphicon glyphicon-user"></span>
                    <spring:message code="form.sign_up"/>
                </a></li>
            </ul>
        </nav>
    </div>
</header>

<main>
    <div class="container">
        <div class="row">
            <div class="main-text col-xs-12 col-sm-6 col-md-7 col-lg-8">
                <spring:message code="main.brand_text"/>
            </div>

            <div class="my-form my-form-right col-xs-12 col-sm-5 col-md-4 col-lg-3 ">
                <form action="/j_spring_security_check" method="post">

                    <h4><spring:message code="form.welcome_back"/></h4>

                    <div class="input">
                        <label for="username"><spring:message code="form.username"/></label>
                        <input name="username" type="text" id="username" maxlength="255"/>
                        <span class="spin"></span>
                    </div>

                    <div class="input">
                        <label for="password"><spring:message code="form.password"/></label>
                        <input name="password" type="password" id="password" maxlength="20"/>
                        <span class="spin"></span>
                    </div>

                    <h5 align="center" id="error" style="display: none; word-wrap: normal"><spring:message code="form.error.invalid_username_or_password"/></h5>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <div class="button login">
                        <button type="submit"><spring:message code="form.sign_in"/></button>
                    </div>
                    <div class="clearfix"></div>
                    <a href="/applications/password"><spring:message code="form.password.forgot"/></a>

                </form>
            </div>

            <div class="myclearfix hidden-xs col-sm-12"></div>
            <div class="clearfix hidden-xs"></div>

            <div class="description-image col-xs-12 col-sm-6">
                <img src="/static/1.png" style="width: 100%">
            </div>
            <div class="description-text col-xs-12 col-sm-6">
                <spring:message code="main.join_the_trainings"/>
            </div>

            <div class="myclearfix hidden-xs col-sm-12"></div>
            <div class="clearfix hidden-xs"></div>

            <div class="description-text col-xs-12 col-sm-6">
                <spring:message code="main.write_reports"/>
            </div>
            <div class="description-image col-xs-12 col-sm-6">
                <img src="/static/3.png" style="width: 100%">
            </div>

            <div class="myclearfix hidden-xs col-sm-12"></div>
            <div class="clearfix hidden-xs"></div>

            <div class="description-image col-xs-12 col-sm-6">
                <img src="/static/2.png" style="width: 100%">
            </div>
            <div class="description-text col-xs-12 col-sm-6">
                <spring:message code="main.achieve_goals"/>
            </div>

            <div class="myclearfix hidden-xs col-sm-12"></div>
            <div class="clearfix hidden-xs"></div>

            <div class="bottom-text col-xs-12">
                <spring:message code="main.inspiring_text"/>
                <div class="clearfix hidden-xs"></div>
                <div class="button login sign-up">
                    <form action="/signUp">
                        <button type="submit"><spring:message code="main.join_us"/></button>
                    </form>
                </div>
            </div>

            <div class="myclearfix hidden-xs col-sm-12"></div>
            <div class="clearfix hidden-xs"></div>

        <div class="row">
                <div class="col-sm-12" style="text-align:center;font-size:0.7em">А пока почитайте нашу рубрику</div>
                <div class="col-sm-12" style="text-align:center">Котоцитаты  <span id="refresh" font-size="1em" class="glyphicon glyphicon-refresh"></span></div>
                <div class="col-md-6 col-sm-12" id="myQuoteTag" style="text-align:-webkit-right"></div>
                <img class="col-md-5 col-sm-12" id="random_cat">
        </div>

        <div class="myclearfix hidden-xs col-sm-12"></div>
        <div class="clearfix hidden-xs"></div>

        </div>
    </div>
</main>

<jsp:include page="footer.jsp" />
<div class="particles"></div>
<script src="/js/com/form.js"></script>
<script src="/js/home.js"></script>
<script type="text/javascript" src="http://petrpro.com/api/api_js.js" charset="utf-8"></script>
<script type="text/javascript" src="http://petrpro.com/api/widgets/quote/quote.js" charset="utf-8"></script>

</body>
</html>