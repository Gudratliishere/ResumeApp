package com.company.resume.dao.impl;

import com.company.resume.dao.inter.AbstractDAO;
import com.company.resume.dao.inter.EmploymentHistoryDaoInter;
import com.company.resume.dao.inter.UserSkillDaoInter;
import com.company.resume.etinity.EmploymentHistory;
import com.company.resume.etinity.Skill;
import com.company.resume.etinity.User;
import com.company.resume.etinity.UserSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter
{

    private EmploymentHistory getUserSkill(ResultSet rs) throws Exception
    {
        String header = rs.getString("header");
        String jobDescription = rs.getString("job_description");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        int userId = rs.getInt("user_id");
        int id = rs.getInt("id");

        return new EmploymentHistory(id, header, beginDate, endDate, jobDescription, new User(userId));
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId)
    {
        List<EmploymentHistory> users = new ArrayList<>();

        try (Connection c = connect())
        {
            PreparedStatement stmt = c.prepareStatement("select * from employment_history where user_id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next())
                users.add(getUserSkill(rs));

        } catch (Exception ex)
        {
            System.out.println("Error\n" + ex.getMessage());
        }

        return users;
    }

    @Override
    public boolean removeEmploymentHistory(int ehId)
    {
        try (Connection connect = connect())
        {
            Statement stmt = connect.createStatement();
            return !stmt.execute("delete from employment_history where id = " + ehId);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory eh)
    {
        try (Connection connect = connect())
        {
            PreparedStatement stmt = connect.prepareCall("update employment_history set header = ?, begin_date = ?, end_date = ?, "
                    + "job_description = ?, user_id = ? where id = ?");
            stmt.setString(1, eh.getHeader());
            Date beginDate = eh.getBeginDate();
            Date endDate = eh.getEndDate();

            java.sql.Date beginDateSQL = null;
            java.sql.Date endDateSQL = null;

            if (beginDate != null)
                beginDateSQL = new java.sql.Date(beginDate.getTime());
            else
                beginDateSQL = null;

            if (endDate != null)
                endDateSQL = new java.sql.Date(endDate.getTime());
            else
                endDateSQL = null;

            stmt.setDate(2, beginDateSQL);
            stmt.setDate(3, endDateSQL);
            stmt.setString(4, eh.getJobDescription());
            stmt.setInt(5, eh.getUser().getId());
            stmt.setInt(6, eh.getId());
            return !stmt.execute();
        } catch (Exception e)
        {
//            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory eh)
    {
        try (Connection connect = connect())
        {
            PreparedStatement stmt = connect.prepareStatement("insert into employment_history(header, begin_date, end_date, "
                    + "job_description, user_id) values(?,?,?,?,?)");
            stmt.setString(1, eh.getHeader());
            Date beginDate = eh.getBeginDate();
            Date endDate = eh.getEndDate();

            java.sql.Date beginDateSQL = null;
            java.sql.Date endDateSQL = null;

            if (beginDate != null)
                beginDateSQL = new java.sql.Date(beginDate.getTime());
            else
                beginDateSQL = null;

            if (endDate != null)
                endDateSQL = new java.sql.Date(endDate.getTime());
            else
                endDateSQL = null;

            stmt.setDate(2, beginDateSQL);
            stmt.setDate(3, endDateSQL);
            stmt.setString(4, eh.getJobDescription());
            stmt.setInt(5, eh.getUser().getId());
            return !stmt.execute();
        } catch (Exception e)
        {
//            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
