package com.company.resume.dao;

import com.company.resume.etinity.UserSkill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserSkillRepositoryCustomImpl implements UserSkillRepositoryCustom
{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        Query query = em.createQuery("SELECT us FROM UserSkill us WHERE us.user.id = :id");
        query.setParameter("id", userId);
        
        return query.getResultList();
    }
}
