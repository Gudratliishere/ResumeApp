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
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    @Override
    public List<Skill> getAll() {
        EntityManager em = getEntitiyManager();
        
        Query query = em.createQuery("SELECT s FROM Skill s");
        
        return query.getResultList();
    }

    @Override
    public Skill getSkillById(int skillId) {
        EntityManager em = getEntitiyManager();
        
        Query query = em.createQuery("SELECT s FROM Skill s WHERE s.id = :id");
        query.setParameter("id", skillId);
        
        List<Skill> list = query.getResultList();
        if (list.size() == 1)
            return list.get(0);
        
        return null;
    }

    @Override
    public boolean updateSkill(Skill skill) {
        EntityManager em = getEntitiyManager();
        
        em.getTransaction().begin();
        em.merge(skill);
        em.getTransaction().commit();
        
        closeEntityManagerFactory();
        
        return true;
    }

    @Override
    public boolean removeSkill(int skillId) {
        EntityManager em = getEntitiyManager();
        
        Skill skill = em.find(Skill.class, skillId);
        
        em.getTransaction().begin();
        em.remove(skill);
        em.getTransaction().commit();
        
        closeEntityManagerFactory();
        
        return true;
    }

    @Override
    public boolean addSkill(Skill skill) {
        EntityManager em = getEntitiyManager();
        
        em.getTransaction().begin();
        em.persist(skill);
        em.getTransaction().commit();
        
        closeEntityManagerFactory();
        
        return true;
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
