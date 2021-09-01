<%-- 
    Document   : User
    Created on : Jun 30, 2021, 11:15:10 PM
    Author     : x
--%>
<%@page import="java.util.List" %>
<%@page import="com.company.resume.etinity.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
              crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/users.css">
        <script src="https://kit.fontawesome.com/cb200fba7e.js" crossorigin="anonymous"></script>
        <script src="assets/js/users.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity=
        "sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity=
        "sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity=
        "sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>

        <%
            List<User> users = (List<User>) request.getAttribute("users");
        %>

        <div class="container">
            <div class="mydiv">
                <div class="myform">
                    <label >Wellcome Admin</label>
                    <form action="logout" method="POST">
                        <button class="btn btn-primary formbutton" name="logout">Log out</button>
                    </form>
                </div>
                <div class="myform">
                    <form action="users" method="GET">
                        <div class="form-group">
                            <label for="name">Name: </label>
                            <input type="text" name="name" class="form-control" placeholder="Name"/>
                            <small class="form-text text-muted">Search by user's name.</small>
                        </div>
                        <br>
                        <div class="form-group">
                            <label for="surname">Surname:</label>
                            <input type="text" name="surname" class="form-control" placeholder="Surname"/>
                            <small class="form-text text-muted">Search by also user's surname.</small>
                        </div>
                        <br>
                        <button type="submit" name="search" class="btn btn-primary formbutton">Search</button>       
                    </form>
                </div>
            </div>
            <div class="mydiv">
                <table class="table">
                    <thead>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Surname</th>
                    <th scope="col">Nationality</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                    </thead>
                    <tbody>
                        <% for (User u: users)
                        { %>
                        <tr>
                            <th scope="row"><%=u.getId()%></th>
                            <td><%=u.getName()%></td>                
                            <td><%=u.getSurname()%></td>
                            <td><%=(u.getNationality().getName() == null) ? "N/A" : u.getNationality().getName()%></td>
                            <td style="width: 5px">
                                <form action="userview" method="GET">
                                    <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                    <button name="view" class="btn btn-secondary">
                                        <i class="fas fa-eye"></i>
                                    </button>
                                </form>
                            </td>
                            <td style="width: 5px">
                                <button type="submit" name="delete" class="btn btn-danger"
                                        data-toggle="modal" data-target="#exampleModal" 
                                        onclick="setUserIdToValue('<%=u.getId()%>')">
                                    <i class="fa fa-trash" aria-hidden="true"></i>
                                </button>    
                            </td>
                            <td style="width: 5px">
                                <form action="useredit" method="GET">
                                    <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                    <button type="submit" name="update" class="btn btn-secondary">
                                        <i class="fa fa-pencil" aria-hidden="true"></i></button>
                                </form>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Are you sure to delete?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <form action="useredit" method="POST">
                                <input type="hidden" name="id" value="" id="id"/>
                                <button type="button" class="btn btn-danger">Delete</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
