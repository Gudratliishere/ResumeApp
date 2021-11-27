/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.dao.impl;

import com.company.resume.dao.inter.AbstractDAO;
import com.company.resume.dao.inter.AdminDaoInter;
import com.company.resume.etinity.Admin;
import java.security.MessageDigest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author x
 */
public class AdminDaoImpl extends AbstractDAO implements AdminDaoInter
{

    @Override
    public List<Admin> getAll(String email)
    {
        EntityManager em = getEntitiyManager();
        
        String queryString = "SELECT a from Admin a WHERE 1 = 1";
        
        if (email != null)
            queryString += " AND a.email = :email";
        
        Query query = em.createQuery(queryString);
        
        if (email != null && !email.trim().isEmpty())
            query.setParameter("email", email);
        
        return query.getResultList();
    }

    @Override
    public boolean updateAdmin(Admin a)
    {
        EntityManager em = getEntitiyManager();

        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        
        closeEntityManagerFactory();
        
        return true;
    }

    @Override
    public boolean removeAdmin(int id)
    {
        EntityManager em = getEntitiyManager();

        Admin admin = em.find(Admin.class, id);

        em.getTransaction().begin();
        em.remove(admin);
        em.getTransaction().commit();
        
        closeEntityManagerFactory();
        
        return true;

    }

    @Override
    public boolean addAdmin(Admin a)
    {
        EntityManager em = getEntitiyManager();

        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        
        closeEntityManagerFactory();
        
        return true;
    }

    @Override
    public Admin getAdminByEmail(String email)
    {
        EntityManager em = getEntitiyManager();

        Query query = em.createQuery("SELECT a from Admin a WHERE a.email = :email");
        query.setParameter("email", email);
        
        List<Admin> list = query.getResultList();
        
        return (list.size() == 1) ? list.get(0) : null;
    }

    @Override
    public Admin checkPassword(Admin admin, String password) throws Exception
    {
        String hashPassword = DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5")
                    .digest(password.getBytes("UTF-8")));
        
        if (hashPassword.equals(admin.getPassword()))
            return admin;
        
        return null;
    }
}
