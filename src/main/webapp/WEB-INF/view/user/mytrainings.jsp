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
    <link rel="stylesheet" type="text/css" href="/css/block.css">

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
                            <span><spring:message code="trainings.all"/></span>
                        </a>
                    </li>
                    <li class="active">
                        <a href="/user/trainings/">
                            <span><spring:message code="trainings.mine"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="/user/reports">
                            <span><spring:message code="reports.many"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="/profile">
                            <span><spring:message code="profile.mine"/></span>
                        </a>
                    </li>
                </ul>
                    <div class="row in-navi">
                        <div class="col-sm-12" style="text-align:center">Котоцитаты  <span id="refresh" font-size="1em" class="glyphicon glyphicon-refresh"></span></div>
                        <div class="col-sm-12" id="myQuoteTag" style="text-align:-webkit-right"></div>
                        <img class="col-sm-12" id="random_cat">
                    </div>

            </div>

            <div id="content" class="col-xs-12 col-sm-6 col-md-8 col-lg-9">
                <div id='result' class="row"></div>

                <div class="row">
                    <div align="center"><div class="button button-big" align="center">
                        <button class="glyphicon glyphicon-circle-arrow-down" id="page" type="button"></button>
                    </div></div>
                </div>
            </div>

            <div class="clearfix"></div>
            <div class="myclearfix col-sm-12"></div>

        </div>
    </div>
</main>

<jsp:include page="../footer.jsp" />

<script src="/js/com/form.js"></script>
<script src="/js/user/mytrainings.js"></script>
</body>
</html>