package main.java.com.company.resume.controller;

import com.company.resume.dao.inter.UserDaoInter;
import com.company.resume.etinity.User;
import com.company.resume.main.Context;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "UsersController", urlPatterns =
{
    "/users"
})
public class UsersController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        UserDaoInter userDao = Context.instanceOfUserDao();
        
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        
        List<User> users = userDao.getAll(name, surname, null);
        
        req.setAttribute("users", users);
        req.getRequestDispatcher("users.jsp").forward(req, resp);
    }
}
