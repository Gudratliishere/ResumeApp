<%-- 
    Document   : User
    Created on : Jun 30, 2021, 11:15:10 PM
    Author     : x
--%>
<%@page import="com.company.resume.dao.inter.UserDaoInter" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="com.company.resume.etinity.User" %>
<%@page import="com.company.resume.main.Context" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
              crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/user.css">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            User user = (User) request.getAttribute("user");
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthdate = sdf.format(user.getBirthdate());
        %>



        <hr>
        <form action="userdetail" method="POST">
            <input type="hidden" name="action" value="update" />
            <input type="hidden" name="id" value="<%=user.getId()%>" />
            <div class="container">
                <div>
                    <label for="name" class="form-text">Name: <%=user.getName()%></label>
                </div>
                <br>
                <div>
                    <label for="surname" class="form-text">Surname: <%=user.getSurname()%></label>
                </div>
                <br>
                <button type="submit" name="save" class="btn btn-primary">Save</button>
            </div>
                <hr>
            <div class="container">
                <h4>Details</h4>
                <label>Email: </label>
                <input type="mail" name="email" value="<%=user.getEmail()%>" class="form-control"/>
                <br>
                <br>
                <label>Phone: </label>
                <input type="text" name="phone" value="<%=user.getPhone()%>" class="form-control"/>
                <br>
                <br>
                <label>Adress: </label>
                <input type="text" name="adress" value="<%=user.getAdress()%>" class="form-control"/>
                <br>
                <br>
                <label>Birthdate: </label>
                <input type="text" name="birthdate" value="<%=birthdate%>" class="form-control"/>
                <br>
            </div>
        </form>
</html>
