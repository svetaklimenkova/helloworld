<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><spring:message code="main.brand"/> </title>
    <link rel="shortcut icon" href="/static/icon.png" type="image/png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <!-- Project CSS -->
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/navbar.css">

    <!-- Font -->
    <link href="https://fonts.googleapis.com/css?family=Caveat" rel="stylesheet">

    <!-- Page content -->
    <link rel="import" href="/view/usermanagement.html">
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

<div class="navi col-xs-12 col-sm-6 col-md-2 col-lg-1">
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

<script src="/js/admin.js"></script>
</body>
</html>