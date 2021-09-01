package com.company.resume.dao.impl;

import com.company.resume.dao.inter.AbstractDAO;
import com.company.resume.dao.inter.EmploymentHistoryDaoInter;
import com.company.resume.etinity.EmploymentHistory;
import com.company.resume.etinity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter
{

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId)
    {
        EntityManager em = getEntitiyManager();

        Query query = em.createQuery("SELECT eh from EmploymentHistory eh WHERE eh.user.id = :id");
        query.setParameter("id", userId);

        return query.getResultList();
    }

    @Override
    public boolean removeEmploymentHistory(int ehId)
    {
        EntityManager em = getEntitiyManager();

        EmploymentHistory eh = em.find(EmploymentHistory.class, ehId);

        em.getTransaction().begin();
        em.remove(eh);
        em.getTransaction().commit();

        closeEntityManagerFactory();

        return true;
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory eh)
    {
        EntityManager em = getEntitiyManager();

        em.getTransaction().begin();
        em.merge(eh);
        em.getTransaction().commit();

        closeEntityManagerFactory();

        return true;
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory eh)
    {
        EntityManager em = getEntitiyManager();

        em.getTransaction().begin();
        em.persist(eh);
        em.getTransaction().commit();

        closeEntityManagerFactory();

        return true;
    }
}
