package main.java.com.company.resume.controller;

import com.company.resume.dao.inter.AdminDaoInter;
import com.company.resume.etinity.Admin;
import com.company.resume.main.Context;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.com.company.resume.controllerutil.ErrorUtil;

@WebServlet(name = "LoginController", urlPatterns =
{
    "/login"
})
public class LoginController extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            AdminDaoInter adminDao = Context.instanceOfAdminDao();

            Admin admin = adminDao.getAdminByEmail(email);
            if (admin == null)
                throw new IllegalArgumentException("admin not found");

            if (!admin.getPassword().equals(password))
                throw new IllegalArgumentException("password is wrong");

            req.getSession().setAttribute("loggedinadmin", admin);
            resp.sendRedirect("users");
        } catch (IOException | IllegalArgumentException e)
        {
            ErrorUtil.sendError(resp, e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
