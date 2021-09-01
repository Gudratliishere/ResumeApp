/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.dao.impl;

import com.company.resume.dao.inter.AbstractDAO;
import com.company.resume.dao.inter.AdminDaoInter;
import com.company.resume.etinity.Admin;
import com.company.resume.etinity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author x
 */
public class AdminDaoImpl extends AbstractDAO implements AdminDaoInter
{

    private Admin getAdmin(ResultSet rs)
    {
        Admin admin = null;

        try
        {
            Integer id = rs.getInt("id");
            String fullName = rs.getString("full_name");
            String email = rs.getString("email");
            String password = rs.getString("password");

            admin = new Admin(id, fullName, email, password);
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return admin;
    }

    @Override
    public List<Admin> getAll(String email)
    {
        List<Admin> admins = new ArrayList<>();
        try (Connection connect = connect())
        {
            String query = "select * from admin where 1 = 1";

            if (email != null && !email.trim().isEmpty())
                query += " and email = ?";

            PreparedStatement stmt = connect.prepareStatement(query);

            if (email != null && !email.trim().isEmpty())
                stmt.setString(1, email);

            stmt.execute();
            
            ResultSet rs = stmt.getResultSet();
            
            while (rs.next())
                admins.add(getAdmin(rs));
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return admins;
    }

    @Override
    public boolean updateAdmin(Admin a)
    {
        try (Connection connect = connect())
        {
            PreparedStatement stmt = connect.prepareStatement("update admin set "
                    + "email = ?, password = ?, full_name = ? where id = ?");
            stmt.setString(1, a.getEmail());
            stmt.setString(1, a.getPassword());
            stmt.setString(1, a.getFullName());
            stmt.setInt(4, a.getId());

            return !stmt.execute();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean removeAdmin(int id)
    {
        try (Connection connect = connect())
        {
            Statement stmt = connect.createStatement();

            return !stmt.execute("delete from admin where id = " + id);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean addAdmin(Admin a)
    {
        try (Connection connect = connect())
        {
            PreparedStatement stmt = connect.prepareCall("insert into admin(email, password, full_name) "
                    + "values(?,?,?)");
            stmt.setString(1, a.getEmail());
            stmt.setString(2, a.getPassword());
            stmt.setString(3, a.getFullName());

            return !stmt.execute();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Admin getAdminByEmail(String email)
    {
        Admin admin = null;
        try (Connection connect = connect())
        {
            PreparedStatement stmt = connect.prepareCall("select * from admin where email = ?");
            stmt.setString(1, email);

            stmt.execute();
            
            ResultSet rs = stmt.getResultSet();

            while (rs.next())
                admin = getAdmin(rs);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return admin;
    }
}
