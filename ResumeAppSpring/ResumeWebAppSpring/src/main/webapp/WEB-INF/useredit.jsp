<%-- 
    Document   : useredit
    Created on : Aug 26, 2021, 10:09:41 PM
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
        <style><%@include file="assets/css/useredit.css" %></style>
        <title>Edit information</title>
    </head>
    <body>
        <form:form action="useredit" method="post" modelAttribute="userDTO">
            <input type="hidden" name="id" value="${userDTO.id}"/>
            <form:input type="hidden" path="id"></form:input>

                <label>Name:</label>
            <form:input path="name"></form:input>
            <form:errors path="name" cssClass="error"/>

            <label>Surname:</label>
            <form:input path="surname"></form:input>
            <form:errors path="surname" cssClass="error" />

            <label>Email: </label>
            <form:input path="email"></form:input>
            <label>Phone:  </label>
            <form:input path="phone"></form:input>
            <label>Profile description:  </label>
            <form:textarea path="profileDescription"></form:textarea>
            <label>Birthdate:  </label>
            <form:input path="birthdate" type="date" value="${birthdate}"></form:input>

            <label>Birth place: </label>
                <select name="birthplaceId">
                <c:forEach items="${country}" var="c">
                    <option value="${c.id}" <c:if test="${userDTO.birthplace.name.equals(c.name)}"> selected="true"</c:if> >
                        ${c.name}
                    </option>
                </c:forEach>
            </select>

            <label>Nationality:  </label>
            <select name="nationalityId">
                <c:forEach items="${country}" var="c">
                    <option value="${c.id}" <c:if test="${userDTO.nationality.name.equals(c.nationality)}"> 
                            selected="true"</c:if> >
                        ${c.nationality}
                    </option>
                </c:forEach>
            </select>

            <!--<h2>Employment History</h2>-->
            <%--<c:forEach items="${userDTO.empHistoryList}" var="emp">--%>
<!--                <input type="text" name="header" value="${emp.header}"/>
                <input type="text" name="begindate" value="${emp.begindate}"/>
                <input type="text" name="enddate" value="${emp.enddate}"/>
                <textarea name="jobDescription">${emp.jobDescription}</textarea>
                <hr>-->
            <%--</c:forEach>--%>

            <!--            <h2>Skills</h2>
                        <table>
                            <tr>
                                <th>Skill</th>
                                <th>Power</th>
                            </tr>
            <%--<c:forEach items="${userDTO.userSkillList}" var="userSkill">--%>
            <tr>
                <td><input class="skill" type="text" name="skill" value="${userSkill.skill.name}"/></td>
                <td><input class="skill" type="text" name="power" value="${userSkill.power}"/></td>
            </tr>
            <%--</c:forEach>--%>
        </table>-->

            <button name="save" type="submit">Save</button>
        </form:form>

        <form action="logout" method="GET">
            <input type="submit" value="Logout"/>
        </form> 
    </body>
</html>