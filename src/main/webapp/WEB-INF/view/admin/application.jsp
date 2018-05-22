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
                        <a href="/applications">
                            <i aria-hidden="true"></i>
                            <span class="hidden-xs hidden-sm"><spring:message code="applications.title"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="/users">
                            <i aria-hidden="true"></i>
                            <span class="hidden-xs hidden-sm"><spring:message code="user_management.title"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="/categories">
                            <i aria-hidden="true"></i>
                            <span class="hidden-xs hidden-sm"><spring:message code="training_categories.title"/></span>
                        </a>
                    </li>
                </ul>
            </div>

            <div id='content' class="content col-xs-12 col-sm-6 col-md-8 col-lg-9">
                <div class="row">
                    <div class="col-xs-12 title">
                        <div class="title-back">
                            <a class="title-back" href="/applications">
                                <spring:message code="main.back"/>
                            </a>
                        </div>
                        <div class="title-text">
                            <spring:message code="applications.one"/> ${application.id}
                        </div>
                        <div class="title-text" id="type"></div>
                        <div class="button button-small">
                            <button class="glyphicon glyphicon-trash" id="delete" type="button"></button>
                        </div>
                        <div class="button button-small">
                            <button class="glyphicon glyphicon-remove-sign" id="reject" type="button"></button>
                        </div>
                        <div class="button button-small">
                            <button class="glyphicon glyphicon-ok-sign" id="accept" type="button"></button>
                        </div>
                    </div>

                    <input id="id" type="hidden" value="${application.id}">

                    <div class="col-xs-12 col-md-4 text-small">
                        <div class="float-left"><b><spring:message code="applications.from"/></b></div>
                        <div class="float-left">:&nbsp;</div>
                        <div id="receiver" class="float-left"></div>
                        <div class="float-left">&nbsp;(</div>
                        <div id="mail" class="float-left"></div>
                        <div class="float-left">)</div>
                    </div>

                    <div class="col-xs-12 col-md-4 text-small">
                        <div class="float-left"><b><spring:message code="applications.createdBy"/></b></div>
                        <div class="float-left">:&nbsp;</div>
                        <div id="createdBy" class="float-left"></div>
                    </div>

                    <div class="col-xs-12 col-md-4 text-small">
                        <div class="float-left"><b><spring:message code="applications.updatedBy"/></b></div>
                        <div class="float-left">:&nbsp;</div>
                        <div id="updatedBy" class="float-left"></div>
                    </div>

                    <div class="clearfix"></div>

                    <div id="description" class="col-xs-12"></div>
                </div>
            </div>

            <div class="clearfix"></div>
            <div class="myclearfix col-sm-12"></div>

        </div>
    </div>
</main>

<jsp:include page="../footer.jsp" />

<script src="/js/admin/application.js"></script>
</body>
</html>