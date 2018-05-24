<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<footer>
    <div class="container">
        <div class="row">
            <div class="spin col-xs-12"></div>
            <div class="clearfix hidden-xs"></div>

            <div class="float-left">
                <spring:message code="main.support"/><br>
                svetaklimenkova@mail.ru<br>
                svetkaklimenkova98@gmail.com</div>
            <div class="float-right" style="text-align: end">
                © 2018 SLIVKI<br>
                <spring:message code="main.brand_text"/>
            </div>
        </div>
    </div>
</footer>

<div class='error_box'>
    <p id='error_message'>Error</p>
</div>

<div class='message_box'>
    <p>***</p>
</div>

<div class="particles"></div>

<script src="/js/fr/jquery-3.3.1.min.js"></script>
<script src="/js/fr/bootstrap.min.js"></script>

<script src="/js/com/common.js"></script>