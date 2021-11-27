<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="assets/css/logout.css" %></style>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="box">
            <h1>Are you sure to logout?</h1>
            <form action="logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value="Logout">
            </form>

            <form action="user" method="get">
                <input type="submit" value="Cancel">
            </form>
        </div>
    </body>
</html>
