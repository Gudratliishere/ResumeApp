package com.company.resume.dao.impl;

import com.company.resume.dao.inter.AbstractDAO;
import com.company.resume.dao.inter.UserDaoInter;
import com.company.resume.dao.inter.UserSkillDaoInter;
import com.company.resume.etinity.Country;
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

public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    private UserSkill getUserSkill (ResultSet rs) throws Exception
    {
        int id = rs.getInt("user_skill_id");
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        return new UserSkill(id, new User(userId), new Skill(skillId, skillName), power);
    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> users = new ArrayList<>();

        try (Connection c = connect())
        {
            PreparedStatement stmt = c.prepareStatement("select " +
                    "u.*, us.id as user_skill_id, us.skill_id, " +
                    "s.name as skill_name, " +
                    "us.power " +
                    "from user_skill us " +
                    "left join user u on us.user_id = u.id " +
                    "left join skill s on us.skill_id = s.id " +
                    "where us.user_id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next())
                users.add(getUserSkill(rs));

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return users;
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill)
    {
        try (Connection connect = connect())
        {
            PreparedStatement stmt = connect.prepareStatement("update user_skill set skill_id = ?, user_id = ?, power = ?");
            stmt.setInt(1, userSkill.getSkill().getId());
            stmt.setInt(2, userSkill.getUser().getId());
            stmt.setInt(3, userSkill.getPower());
            return !stmt.execute();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean removeUserSkill(int userSkillId)
    {
        try (Connection connect = connect())
        {
            Statement stmt = connect.createStatement();
            return !stmt.execute("delete from user_skill where id = " + userSkillId);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean addUserSkill(UserSkill userSkill)
    {
        try (Connection connect = connect())
        {
            PreparedStatement stmt = connect.prepareStatement("insert into user_skill(skill_id, user_id, power) values(?, ?, ?)");
            stmt.setInt(1, userSkill.getSkill().getId());
            stmt.setInt(2, userSkill.getUser().getId());
            stmt.setInt(3, userSkill.getPower());
            return !stmt.execute();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
