package com.company.resume.dao.impl;

import com.company.resume.dao.inter.AbstractDAO;
import com.company.resume.dao.inter.CountryDaoInter;
import com.company.resume.etinity.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter
{

    @Override
    public List<Country> getAll()
    {
        EntityManager em = getEntitiyManager();

        Query query = em.createQuery("SELECT c FROM Country c");

        return query.getResultList();
    }

    @Override
    public Country getCountryById(int countryId)
    {
        EntityManager em = getEntitiyManager();

        Query query = em.createQuery("SELECT c FROM Country c WHERE c.id = :id");
        query.setParameter("id", countryId);

        List<Country> list = query.getResultList();
        if (list.size() == 1)
            return list.get(0);

        return null;
    }

    @Override
    public boolean removeCountry(int countryId)
    {
        EntityManager em = getEntitiyManager();

        Country country = em.find(Country.class, countryId);

        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();

        closeEntityManagerFactory();

        return true;
    }

    @Override
    public boolean updateCountry(Country country)
    {
        EntityManager em = getEntitiyManager();

        em.getTransaction().begin();
        em.merge(country);
        em.getTransaction().commit();

        closeEntityManagerFactory();

        return true;
    }

    @Override
    public boolean addCountry(Country country)
    {
        EntityManager em = getEntitiyManager();

        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();

        closeEntityManagerFactory();

        return true;
    }
}
