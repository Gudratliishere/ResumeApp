package com.company.resume.main;

import com.company.resume.dao.impl.AdminDaoImpl;
import com.company.resume.dao.inter.UserDaoInter;
import com.company.resume.dao.inter.CountryDaoInter;
import com.company.resume.dao.inter.EmploymentHistoryDaoInter;
import com.company.resume.dao.inter.UserSkillDaoInter;
import com.company.resume.dao.inter.SkillDaoInter;
import com.company.resume.dao.impl.UserDaoImpl;
import com.company.resume.dao.impl.SkillDaoImpl;
import com.company.resume.dao.impl.CountryDaoImpl;
import com.company.resume.dao.impl.UserSkillDaoImpl;
import com.company.resume.dao.impl.EmploymentHistoryDaoImpl;
import com.company.resume.dao.inter.AdminDaoInter;
import com.company.resume.etinity.Skill;

import java.util.List;

public class Context {
    public static UserDaoInter instanceOfUserDao ()
    {
        return new UserDaoImpl();
    }

    public static UserSkillDaoInter instanceOfUserSkillDao()
    {
        return new UserSkillDaoImpl();
    }

    public static EmploymentHistoryDaoInter instanceOfEmploymentHistoryDao()
    {
        return new EmploymentHistoryDaoImpl();
    }

    public static CountryDaoInter instanceOfCountryDao()
    {
        return new CountryDaoImpl();
    }

    public static SkillDaoInter instanceOfSkillDao()
    {
        return new SkillDaoImpl();
    }
    
    public static AdminDaoInter instanceOfAdminDao()
    {
        return new AdminDaoImpl();
    }
}
