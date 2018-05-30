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
                            <i class="fa fa-home" aria-hidden="true"></i>
                            <span class="hidden-xs hidden-sm"><spring:message code="applications.title"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="/users">
                            <i class="fa fa-calendar" aria-hidden="true"></i>
                            <span class="hidden-xs hidden-sm"><spring:message code="user_management.title"/></span>
                        </a>
                    </li>
                    <li class="active">
                        <a href="/categories">
                            <i class="fa fa-cog" aria-hidden="true"></i>
                            <span class="hidden-xs hidden-sm"><spring:message code="training_categories.title"/></span>
                        </a>
                    </li>
                </ul>
            </div>

            <div id='content' class="content col-xs-12 col-sm-6 col-md-8 col-lg-9">
                <div class="row">
                    <div class="role col-xs-12"><b><spring:message code="trainings.categories"/></b></div>
                </div>
                <div class="row">
                    <div class="input col-lg-11"><input id="category"></div>
                    <div class="button button-small col-lg-1">
                        <button class="glyphicon glyphicon-plus-sign" id="add" type="button"></button>
                    </div>
                </div>
                <ul class="list">

                </ul>
            </div>

            <div class="clearfix"></div>
            <div class="myclearfix col-sm-12"></div>

        </div>
    </div>
</main>

<jsp:include page="../footer.jsp" />

<input id="category_added" type="hidden" value="<spring:message code="categories.added"/>">
<input id="category_updated" type="hidden" value="<spring:message code="categories.updated"/>">
<input id="category_empty" type="hidden" value="<spring:message code="categories.empty"/>">
<input id="category_deleted" type="hidden" value="<spring:message code="categories.deleted"/>">
<input id="category_really_delete" type="hidden" value="<spring:message code="categories.really_delete"/>">
<input id="category_size" type="hidden" value="<spring:message code="form.categoryName.size"/>">

<script src="/js/fr/list.min.js"></script>

<script src="/js/admin/categories.js"></script>
</body>
</html>