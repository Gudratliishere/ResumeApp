/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.company.resume.controller;

import com.company.resume.dao.inter.CountryDaoInter;
import com.company.resume.dao.inter.EmploymentHistoryDaoInter;
import com.company.resume.dao.inter.UserDaoInter;
import com.company.resume.etinity.Country;
import com.company.resume.etinity.EmploymentHistory;
import com.company.resume.etinity.User;
import com.company.resume.main.Context;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.com.company.resume.controllerutil.ErrorUtil;

/**
 *
 * @author x
 */
@WebServlet(name = "UserEditController", urlPatterns =
{
    "/useredit"
})
public class UserEditController extends HttpServlet
{

    private void setUserParameter(User user, HttpServletRequest request)
    {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String adress = request.getParameter("adress");
        String birthdate = request.getParameter("birthdate");
        String birthplace = request.getParameter("birthplace");
        String nationality = request.getParameter("natinality");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        java.sql.Date birthdateSQL = null;

        try
        {
            java.util.Date date = sdf.parse(birthdate);
            birthdateSQL = new java.sql.Date(date.getTime());
        } catch (ParseException ex)
        {
            Logger.getLogger(UserEditController.class.getName()).log(Level.SEVERE, null, ex);
        }

        user.setName(name);
        user.setSurname(surname);
        user.setAdress(adress);
        user.setEmail(email);
        user.setPhone(phone);
        user.setBirthdate(birthdateSQL);
        user.setBirthplace(new Country(2, birthplace, null));        
        user.setNationality(new Country(2, null, nationality));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        UserDaoInter userDao = Context.instanceOfUserDao();

        String action = request.getParameter("action");
        String id = request.getParameter("id");
        Integer userId = Integer.parseInt(id);

        if (action.equals("update"))
        {
            User user = userDao.getUserById(userId);
            setUserParameter(user, request);

            userDao.updateUser(user);
        }
        else if (action.equals("delete"))
            userDao.removeUser(userId);

        response.sendRedirect("users");
    }

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
            
            CountryDaoInter countryDao = Context.instanceOfCountryDao();
            List<Country> countries = countryDao.getAll();
            
            req.setAttribute("countries", countries);
            
            EmploymentHistoryDaoInter empDao = Context.instanceOfEmploymentHistoryDao();
            List<EmploymentHistory> emph = empDao.getAllEmploymentHistoryByUserId(userId);
            
            req.setAttribute("emph", emph);
            
            req.getRequestDispatcher("useredit.jsp").forward(req, resp);
        } catch (ServletException | IOException | IllegalArgumentException e)
        {
            e.printStackTrace();
            ErrorUtil.sendError(resp, e);
        }
    }

}
