package com.company.resume.dao;

import com.company.resume.dao.UserLoginRepositoryCustom;
import com.company.resume.etinity.UserLogin;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.security.MessageDigest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.bind.DatatypeConverter;

@Repository
public class UserLoginRepositoryCustomImpl implements UserLoginRepositoryCustom
{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<UserLogin> getAll()
    {
        Query query = em.createQuery("select ul from UserLogin ul");
        
        return query.getResultList();
    }

    @Override
    public UserLogin checkPassword(UserLogin login, String password) throws Exception
    {
        Boolean result = new BCryptPasswordEncoder().matches(password, login.getPassword());
        
        if (result)
            return login;
        
        return null;
    }
    
}