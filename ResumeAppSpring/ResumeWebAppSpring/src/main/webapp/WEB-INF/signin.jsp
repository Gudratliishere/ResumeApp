<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign in</title>
        <style> <%@include file="assets/css/signin.css" %>%></style>
    </head>
    <body>
        <form:form cssClass="box" action="signin" method="post" modelAttribute="userLoginDTO">
            <h1>Signin</h1>
            
            <form:input type="text" path="email" placeholder="Your email.."/>
            <c:if test="${emailexist}">
                <label class="error">Email already in use</label>
            </c:if>
            <form:errors path="email" cssClass="error"/>
            
            <form:input type="password" path="password" placeholder="Your password.." />
            <form:errors cssClass="error" path="password"/>
            
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

            <form:input type="password" path="confirmPassword" placeholder="Confrm password" />
            <form:errors path="confirmPassword" cssClass="error"/>
            <c:if test="${passworddifferent}">
                <label class="error">Password is not equal</label>
            </c:if>

            <button type="submit" name="submit">Sign in</button>
        </form:form>
</body>
</html>
