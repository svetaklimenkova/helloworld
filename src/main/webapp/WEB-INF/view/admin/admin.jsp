<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<body>
<!-- Navigation Bar -->
<header>
    <nav class="navbar mynav">
        <div class="container-fluid">
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
    <div class="container-fluid">
        <div class="row">
            <div class="navi col-xs-12 col-sm-6 col-md-4 col-lg-3">
                <ul>
                    <li class="active">
                        <a href="#">
                            <i class="fa fa-home" aria-hidden="true"></i>
                            <span class="hidden-xs hidden-sm"><spring:message code="applications.title"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-calendar" aria-hidden="true"></i>
                            <span class="hidden-xs hidden-sm"><spring:message code="user_management.title"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-cog" aria-hidden="true"></i>
                            <span class="hidden-xs hidden-sm"><spring:message code="training_categories.title"/></span>
                        </a>
                    </li>
                </ul>
            </div>

            <div class="content my-form col-xs-12 col-sm-6 col-md-8 col-lg-9">
            </div>

        </div>
    </div>
</main>

<script src="/js/fr/jquery-3.3.1.min.js"></script>
<script src="/js/fr/bootstrap.min.js"></script>

<script src="/js/admin.js"></script>
</body>
</html>