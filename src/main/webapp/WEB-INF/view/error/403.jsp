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
    <style>
        .very-big-text {
            font-size: 450px;
            text-align: center;
            line-height: 0.8;
        }
        .big-text {
            font-size: 80px;
            text-align: center;
            line-height: 1.2;
        }
        .text {
            font-size: 25px;
            text-align: center;
            line-height: 1;
            padding-top: 20px;
        }
    </style>
</head>

<c:import url="../preloader.jsp"/>

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
            </ul>
        </nav>
    </div>
</header>

<main>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 very-big-text">
                403
            </div>
            <div class="col-xs-12 big-text">
                <spring:message code="main.access_denied"/>
            </div>
            <div class="col-xs-12 text">
                <spring:message code="main.access_denied_description"/>
            </div>

            <div class="clearfix"></div>
            <div class="myclearfix col-sm-12"></div>
        </div>
    </div>
</main>

<jsp:include page="../footer.jsp" />

<div class="particles"></div>

<script src="/js/com/form.js"></script>
<script src="/js/home.js"></script>

</body>
</html>