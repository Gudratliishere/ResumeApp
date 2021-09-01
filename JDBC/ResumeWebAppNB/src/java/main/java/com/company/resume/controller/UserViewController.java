/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author x
 */
@WebServlet(name = "UserViewController", urlPatterns =
{
    "/userview"
})
public class UserViewController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            String userIdString = req.getParameter("id");
            if (userIdString == null || userIdString.trim().isEmpty())
                throw new IllegalArgumentException("Id is not specified!");

            Integer userId = Integer.parseInt(userIdString);

            UserDaoInter userDao = Context.instanceOfUserDao();
            User u = userDao.getUserById(userId);
            if (u == null)
                throw new IllegalArgumentException("There is not any user with this id!");

            req.setAttribute("user", u);
            req.getRequestDispatcher("userview.jsp").forward(req, resp);
        } catch (ServletException | IOException | IllegalArgumentException e)
        {
            e.printStackTrace();
            resp.sendRedirect("error.jsp?msg=" + e.getMessage());
        }
    }

}
