package com.company.resume.dao.impl;

import com.company.resume.dao.inter.AbstractDAO;
import com.company.resume.dao.inter.SkillDaoInter;
import com.company.resume.etinity.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    private Skill getSkill (ResultSet rs) throws SQLException
    {
        int id = rs.getInt("id");
        String name = rs.getString("name");

        return new Skill(id, name);
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> skills = new ArrayList<>();

        try (Connection c = connect())
        {
            Statement stmt = c.createStatement();
            stmt.execute("select * from skill");
            ResultSet rs = stmt.getResultSet();

            while (rs.next())
                skills.add(getSkill(rs));
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        return skills;
    }

    @Override
    public Skill getSkillById(int skillId) {
        Skill skill = null;
        
        try (Connection connect = connect())
        {
            Statement stmt = connect.createStatement();
            stmt.execute("select name from skill where id = " + skillId);
            ResultSet rs = stmt.getResultSet();
            
            while (rs.next())
            {
                String name = rs.getString("name");
                skill = new Skill(skillId, name);
            }
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return skill;
    }

    @Override
    public boolean updateSkill(Skill skill) {
        try (Connection connect = connect())
        {
            PreparedStatement stmt = connect.prepareStatement("update skill set name = ? where id = ?");
            stmt.setString(1, skill.getName());
            stmt.setInt(2, skill.getId());
            return !stmt.execute();
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean removeSkill(int skillId) {
        try (Connection connect = connect()) 
        {
            Statement stmt = connect.createStatement();
            return !stmt.execute("delete from skill where id = " + skillId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean addSkill(Skill skill) {
        try (Connection connect = connect()) 
        {
            PreparedStatement stmt = connect.prepareStatement("insert into skill(name) values(?)");
            stmt.setString(1, skill.getName());
            return !stmt.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean existSkill(Skill skill)
    {
        List<Skill> list = getAll();
        
        for (Skill s: list) 
            if (s.getName().equals(skill.getName())) return true;
        
        return false;
    }
}
