package com.company.resume.dao.impl;

import com.company.resume.etinity.Country;
import com.company.resume.etinity.User;
import com.company.resume.dao.inter.AbstractDAO;
import com.company.resume.dao.inter.UserDaoInter;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter
{

//With JPQL
    @Override
    public List<User> getAll(String name, String surname, Country nid)
    {
        EntityManager em = getEntitiyManager();

        String query = "select u from User u where 1 = 1";

        if (name != null && !name.trim().isEmpty())
            query += " and u.name = :name";
        if (surname != null && !surname.trim().isEmpty())
            query += " and u.surname = :surname";
        if (nid != null)
            query += " and u.nationality = :nationality";

        Query resultQuery = em.createQuery(query);

        if (name != null && !name.trim().isEmpty())
            resultQuery.setParameter("name", name);
        if (surname != null && !surname.trim().isEmpty())
            resultQuery.setParameter("surname", surname);
        if (nid != null)
            resultQuery.setParameter("nationality", nid);

        return resultQuery.getResultList();
    }
    
//With criteria builder
//    @Override
//    public List<User> getAll(String name, String surname, Country nationality)
//    {
//        EntityManager em = getEntitiyManager();
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> criteariaQuery = cb.createQuery(User.class);
//        Root<User> postRoot = criteariaQuery.from(User.class);
//
//        CriteriaQuery<User> criteariaQuery2 = null;
//
//        if (name != null && surname == null && nationality == null)
//            criteariaQuery2 = criteariaQuery.where(cb.equal(postRoot.get("name"), name));
//
//        if (surname != null && name == null && nationality == null)
//            criteariaQuery2 = criteariaQuery.where(cb.equal(postRoot.get("surname"), surname));
//        
//        if (nationality != null && surname == null && name == null)
//            criteariaQuery2 = criteariaQuery.where(cb.equal(postRoot.get("nationality"), nationality)); 
//        
//        if (name != null && surname != null && nationality == null)
//            criteariaQuery2 = criteariaQuery.where(cb.equal(postRoot.get("name"), name),
//                    cb.equal(postRoot.get("surname"), surname));      
//        
//        if (name != null && surname == null && nationality != null)
//            criteariaQuery2 = criteariaQuery.where(cb.equal(postRoot.get("name"), name),
//                    cb.equal(postRoot.get("nationality"), nationality));  
//        
//        if (name == null && surname != null && nationality != null)
//            criteariaQuery2 = criteariaQuery.where(cb.equal(postRoot.get("nationality"), nationality),
//                    cb.equal(postRoot.get("surname"), surname));        
//        
//        if (name != null && surname != null && nationality != null)
//            criteariaQuery2 = criteariaQuery.where(cb.equal(postRoot.get("name"), name),
//                    cb.equal(postRoot.get("surname"), surname),
//                    cb.equal(postRoot.get("nationality"), nationality));
//        
//        Query query;
//
//        if (name == null && surname == null && nationality == null)
//            query = em.createQuery(criteariaQuery);
//        else
//            query = em.createQuery(criteariaQuery2);
//
//        return query.getResultList();
//    }

    @Override
    public boolean updateUser(User u)
    {
        EntityManager em = getEntitiyManager();

        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();

        closeEntityManagerFactory();

        return true;
    }

    @Override
    public boolean removeUser(int id)
    {
        EntityManager em = getEntitiyManager();

        User u = em.find(User.class,
                id);

        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();

        closeEntityManagerFactory();

        return true;
    }

    @Override
    public boolean addUser(User u)
    {
        EntityManager em = getEntitiyManager();

        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();

        closeEntityManagerFactory();

        return true;
    }

    @Override
    public User getUserById(int userId)
    {
        EntityManager em = getEntitiyManager();

        User user = em.find(User.class,
                userId);

        closeEntityManagerFactory();

        return user;
    }
}
