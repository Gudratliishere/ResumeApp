<%-- 
    Document   : User
    Created on : Jun 30, 2021, 11:15:10 PM
    Author     : x
--%>
<%@page import="com.company.resume.dao.inter.UserDaoInter" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.List" %>
<%@page import="com.company.resume.etinity.Country" %>
<%@page import="com.company.resume.etinity.User" %>
<%@page import="com.company.resume.main.Context" %>
<%@page import="com.company.resume.etinity.EmploymentHistory" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
              crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/useredit.css">
        <script src="assets/js/useredit.js"></script>
        <title>JSP Page</title>
    </head>
    <body>

        <%
            User user = (User) request.getAttribute("user");
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthdate = "";
            if (user.getBirthdate() != null)
                birthdate = sdf.format(user.getBirthdate());
            
            List<Country> countries = (List<Country>) request.getAttribute("countries");
            List<EmploymentHistory> emph = (List<EmploymentHistory>) request.getAttribute("emph");
        %>




        <form action="useredit" method="POST">
            <input type="hidden" name="action" value="update" />
            <input type="hidden" name="id" value="<%=user.getId()%>" />
            <div class="container">
                <div class="mydiv">
                    <div id="myform">
                        <div>
                            <label for="name">Name: </label>
                            <input type="text" name="name" value="<%=user.getName()%>" class="form-control"/>
                        </div>
                        <br>
                        <div>
                            <label for="surname">Surname:</label>
                            <input type="text" name="surname" value="<%=user.getSurname()%>" class="form-control"/>
                        </div>
                        <br>
                        <button type="submit" name="save" class="btn btn-primary" id="search">Save</button>
                    </div>
                </div>
            </div>
            <hr>
            <div class="container">
                <h4>Profile Description</h4>
                <textarea name="profileDesc" class="form-control"><%=(user.getProfileDescription() != null) ? 
                    user.getProfileDescription() : ""%></textarea>
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
                <input type="text" name="adress" value="<%=(user.getAdress() != null) ? user.getAdress() : ""%>" class="form-control"/>
                <br>
                <br>
                <label>Birthdate: </label>
                <input type="text" name="birthdate" value="<%=birthdate%>" class="form-control"/>
                <br>
                <label>Birth place: </label>
                <select name="birthplace" class="form-control">
                    <% for (Country country: countries)
                    {%>
                    <option <%if (country.getName().equals(user.getBirthplace().getName())){%>
                        selected="<%=true%>" <%}%>><%=country.getName()%></option>
                    <%}%>
                </select>
                <br>
                <label>Nationality: </label>
                <select name="nationality" class="form-control">
                    <% for (Country country: countries)
                    {%>
                    <option <%if (country.getNationality().equals(user.getNationality().getNationality())){%>
                        selected="<%=true%>" <%}%>><%=country.getNationality()%></option>
                    <%}%>
                </select>
            </div>
            <hr>
            <div class="container">
                <h4>Employment History</h4>
                <select class="form-control" id="emphlist">
                <%for (EmploymentHistory eh: emph)
                {
                    String begindate = "", enddate = "";
                    if (eh.getBeginDate() != null)
                        begindate = sdf.format(eh.getBeginDate());
                    if (eh.getEndDate() != null)
                        enddate = sdf.format(eh.getEndDate());
                %>
                <option onclick="fillEmploymentHistory()" value="<%=eh%>" ><%=eh.getHeader()%></option>
                <%}%>
                </select>
                <label>Begin date: </label>
                <input class="form-control" type="text" name="begindate" value="" id="begindate"/>

                <label>End date: </label>
                <input class="form-control" type="text" name="enddate" value="<%//=enddate%>" id="enddate"/>

                <label>Job Description: </label>
                <textarea type="text" class="form-control" name="jobDesc" id="jobDesc"><%//=eh.getJobDescription()%></textarea>
                <hr>
                
<!--                <label>Header: </label>
                <input class="form-control" type="text" name="header" value="<%//=eh.getHeader()%>"/>

                <label>Begin date: </label>
                <input class="form-control" type="text" name="begindate" value="<%//=begindate%>"/>

                <label>End date: </label>
                <input class="form-control" type="text" name="enddate" value="<%//=enddate%>"/>

                <label>Job Description: </label>
                <textarea type="text" class="form-control" name="jobDesc"><%//=eh.getJobDescription()%></textarea>
                <hr>-->
            </div>
            <hr>
            <div class="container">
                <h4>Skills</h4>
            </div>
            <hr>
        </form>
</html>
