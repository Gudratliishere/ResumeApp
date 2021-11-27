<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="/WEB-INF/assets/css/login.css"%></style>
        <script>
            function wrong()
            {
                var username = document.getElementById('username');
                var password = document.getElementById('password');

                username.style.borderColor = "red";
                password.style.borderColor = "red";
            }
        </script>
    </head>
    <body>
        <form class="box" action="login" method="post">
            <h1>Login</h1>

            <c:if test="${not empty param.success && param.success == true}">
                <div class="register">Registration successfull!</div>
            </c:if>

            <input type="text" name="username" id="username" placeholder=" Your email.."/>
            <input type="password" name="password" id="password" placeholder="Your password.."/>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

            <c:if test="${not empty param.error}">
                <script>wrong()</script>
                <div class="wrong">Email or password is wrong!</div>
            </c:if>
            <input type="submit" name="submit" value="Log in"/>
            
            <div class="signin">Do you have not account yet? Create</div>
            <a href="signin" class="link"> new one!<a/>
        </form> 
    </body>
</html>