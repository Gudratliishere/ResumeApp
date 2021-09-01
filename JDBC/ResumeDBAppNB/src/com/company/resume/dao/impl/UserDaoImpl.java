package com.company.resume.dao.impl;

import com.company.resume.etinity.Country;
import com.company.resume.etinity.User;
import com.company.resume.dao.inter.AbstractDAO;
import com.company.resume.dao.inter.UserDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {
    @Override
    public List<User> getAll(String name, String surname, Integer nid) {
        List<User> users = new ArrayList<>();

        try (Connection c = connect())
        {
            String query = "select "
                    + " u.*, "
                    + " n.nationality, "
                    + " c.name as birthplace "
                    + " from user u "
                    + " left join country n on u.nationality_id = n.id "
                    + " left join country c on u.birthplace_id = c.id where 1 = 1";
            
            if (name != null && !name.trim().isEmpty())
                query += " and u.name = ?";
            if (surname != null && !surname.trim().isEmpty())
                query += " and u.surname = ?";
            if (nid != null)
                query += " and u.nationality_id = ?";
            
            PreparedStatement stmt = c.prepareStatement(query);
            
            int index = 1;
            if (name != null && !name.trim().isEmpty())
                stmt.setString(index, name);
            if (surname != null && !surname.trim().isEmpty())
                stmt.setString(index, surname);
            if (nid != null)
                stmt.setInt(index, nid);
            
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next())
                users.add(getUser(rs));

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return users;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect())
        {
            PreparedStatement stmt = c.prepareStatement("update user set name = ?, surname = ?, phone = ?, email = ?, "
                    + "profile_description = ?, adress = ?, birthdate = ?, birthplace_id = ?, nationality_id = ? where id = ?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDescription());
            stmt.setString(6, u.getAdress());
            stmt.setDate(7, new java.sql.Date(u.getBirthdate().getTime()));
            stmt.setInt(8, u.getBirthplace().getId());
            stmt.setInt(9, u.getNationality().getId());
            stmt.setInt(10, u.getId());

            return !stmt.execute();
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect())
        {
            Statement stmt = c.createStatement();
            return !stmt.execute("delete from user where id = " + id);
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect())
        {
            PreparedStatement stmt = c.prepareStatement("insert into user(name, surname, phone, email, profile_description, "
                    + "adress, birthdate, birthplace_id, nationality_id) " +
                    "values(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDescription());
            stmt.setString(6, u.getAdress());
            stmt.setDate(7, new java.sql.Date(u.getBirthdate().getTime()));
            stmt.setInt(8, u.getBirthplace().getId());
            stmt.setInt(9, u.getNationality().getId());
            
            return !stmt.execute();

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public User getUserById(int userId) {
        User result = null;

        try (Connection c = connect())
        {
            Statement stmt = c.createStatement();
            stmt.execute("select "
                    + " u.*, "
                    + " n.nationality, "
                    + " c.name as birthplace "
                    + " from user u "
                    + " left join country n on u.nationality_id = n.id "
                    + " left join country c on u.birthplace_id = c.id where u.id = " + userId);
            ResultSet rs = stmt.getResultSet();

            while (rs.next())
                result = getUser(rs);
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    private User getUser (ResultSet rs) throws Exception
    {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDescription = rs.getString("profile_description");
        String adress = rs.getString("adress");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthplaceStr = rs.getString("birthplace");
        Date birthdate = rs.getDate("birthdate");

        Country nationality = new Country(nationalityId, null, nationalityStr);
        Country birthplace = new Country(birthplaceId, birthplaceStr, null);

        return new User(id, name, surname, email, phone, profileDescription, adress,
                birthdate, birthplace, nationality);
    }
}
