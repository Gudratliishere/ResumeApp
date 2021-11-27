<%-- 
    Document   : user
    Created on : Aug 22, 2021, 6:39:21 PM
    Author     : Dunay Gudratli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="assets/css/user.css"%></style>
        <title>JSP Page</title>
    </head>
    <body>

        <c:if test="${not empty param.edit && param.edit == true}">
            <div class="edit">Edit information successfull!</div>
        </c:if>

        <c:if test="${userDTO.name == null}">
            <label class="noInfo">There is not resume info yet..</label>
        </c:if>

        <h1>${userDTO.name} ${userDTO.surname}</h1>
        <label>Email and phone: </label>
        <label>${userDTO.email} ${userDTO.phone}</label>
        <label>Profile description: </label>
        <p>${userDTO.profileDescription}</p>
        <label>Birthdate: </label>
        <label>${birthdate}</label>
        <label>Birth place: ${userDTO.birthplace.name}</label>
        <label>Nationality: ${userDTO.nationality.nationality}</label>

        <h2>Employment History</h2>
        <c:forEach items="${userDTO.empHistoryList}" var="emp">
            <h3>${emp.header}</h3>
            <label>${emp.begindate}   ${emp.enddate}</label>
            <p>${emp.jobDescription}</p>
        </c:forEach>

        <h2>Skils</h2>
        <c:forEach items="${userDTO.userSkillList}" var="userSkill">
            <label>${userSkill.skill.name}</label>
            <label>${userSkill.power}</label>
        </c:forEach>

        <form action="useredit" method="get">
            <c:if test="${userDTO.id == null}">
                <input type="hidden" name="id" value="0"/>
            </c:if>
            <c:if test="${userDTO.id != null}">
                <input type="hidden" name="id" value="${userDTO.id}"/>
            </c:if>
            <input type="submit" value="Edit"/>
        </form> 

        <form action="logout" method="GET">
            <input type="submit" value="Logout"/>
        </form> 
    </body>
</html>
