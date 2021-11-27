package com.company.resume.dao;

import com.company.resume.etinity.Country;
import com.company.resume.etinity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom
{

    @PersistenceContext
    EntityManager em;
    
    @Override
    public List<User> getAll(String name, String surname, Country nid)
    {
        String query = "select u from User u where 1 = 1";

        if (name != null && !name.trim().isEmpty())
            query += " and u.name = :name";
        if (surname != null && !surname.trim().isEmpty())
            query += " and u.surname = :surname";
        if (nid != null)
            query += " and u.nationality = :nationality";

        Query resultQuery = em.createQuery(query, User.class);

        if (name != null && !name.trim().isEmpty())
            resultQuery.setParameter("name", name);
        if (surname != null && !surname.trim().isEmpty())
            resultQuery.setParameter("surname", surname);
        if (nid != null)
            resultQuery.setParameter("nationality", nid);

        return resultQuery.getResultList();
    }
}
