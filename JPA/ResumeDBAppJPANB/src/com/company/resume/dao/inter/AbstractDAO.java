package com.company.resume.dao.inter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDAO
{

    private static EntityManagerFactory emf = null;

    public EntityManager getEntitiyManager()
    {
        if (emf == null)
            emf = Persistence.createEntityManagerFactory("resumeappPU");

        EntityManager em = emf.createEntityManager();
        return em;
    }

    public void closeEntityManagerFactory()
    {
        emf.close();
        emf = null;
    }
}