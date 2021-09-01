/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.dao.impl;

import com.company.resume.dao.inter.AbstractDAO;
import com.company.resume.dao.inter.UserLoginDaoInter;
import com.company.resume.etinity.UserLogin;
import java.security.MessageDigest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author x
 */
public class UserLoginDaoImpl extends AbstractDAO implements UserLoginDaoInter
{

    @Override
    public List<UserLogin> getAll()
    {
        EntityManager em = getEntitiyManager();
        
        Query query = em.createQuery("select ul from UserLogin ul");
        
        return query.getResultList();
    }

    @Override
    public UserLogin findLogin(String email)
    {
        EntityManager em = getEntitiyManager();
        
        Query query = em.createQuery("SELECT ul FROM UserLogin ul WHERE ul.email = :email");
        query.setParameter("email", email);
        
        List<UserLogin> list = query.getResultList();
        if (list.size() == 1)
            return list.get(0);
        
        return null;
    }

    @Override
    public boolean updateLogin(UserLogin login)
    {
        EntityManager em = getEntitiyManager();
        
        em.getTransaction().begin();
        em.merge(login);
        em.getTransaction().commit();
        
        closeEntityManagerFactory();
        
        return true;
    }

    @Override
    public boolean removeLogin(Integer id)
    {
        EntityManager em  = getEntitiyManager();
        
        UserLogin ul = em.find(UserLogin.class, id);
        
        em.getTransaction().begin();
        em.remove(ul);
        em.getTransaction().commit();
        
        closeEntityManagerFactory();
        
        return true;
    }

    @Override
    public boolean addLogin(UserLogin login)
    {
        EntityManager em = getEntitiyManager();
        
        em.getTransaction().begin();
        em.persist(login);
        em.getTransaction().commit();
        
        closeEntityManagerFactory();
        
        return true;
    }

    @Override
    public UserLogin checkPassword(UserLogin login, String password) throws Exception
    {
        String hashPassword = DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5")
                    .digest(password.getBytes("UTF-8")));
        
        if (hashPassword.equals(login.getPassword()))
            return login;
        
        return null;
    }
    
}
