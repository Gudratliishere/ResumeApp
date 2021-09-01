package com.company.resume.dao.impl;

import com.company.resume.dao.inter.AbstractDAO;
import com.company.resume.dao.inter.UserSkillDaoInter;
import com.company.resume.etinity.UserSkill;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        EntityManager em  = getEntitiyManager();
        
        Query query = em.createQuery("SELECT us FROM UserSkill us WHERE us.user.id = :id");
        query.setParameter("id", userId);
        
        return query.getResultList();
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill)
    {
        EntityManager em = getEntitiyManager();
        
        em.getTransaction().begin();
        em.merge(userSkill);
        em.getTransaction().commit();
        
        closeEntityManagerFactory();
        
        return true;
    }

    @Override
    public boolean removeUserSkill(int userSkillId)
    {
        EntityManager em = getEntitiyManager();
        
        UserSkill us = em.find(UserSkill.class, userSkillId);
        
        em.getTransaction().begin();
        em.remove(us);
        em.getTransaction().commit();
        
        closeEntityManagerFactory();
        
        return true;
    }

    @Override
    public boolean addUserSkill(UserSkill userSkill)
    {
        EntityManager em = getEntitiyManager();
        
        em.getTransaction().begin();
        em.persist(userSkill);
        em.getTransaction().commit();
        
        closeEntityManagerFactory();
        
        return true;
    }
}
