package com.company.resume.main;

import com.company.resume.dao.impl.AdminDaoImpl;
import com.company.resume.dao.inter.AdminDaoInter;
import com.company.resume.dao.inter.CountryDaoInter;
import com.company.resume.dao.inter.EmploymentHistoryDaoInter;
import com.company.resume.dao.inter.SkillDaoInter;
import com.company.resume.etinity.User;
import com.company.resume.dao.inter.UserDaoInter;
import com.company.resume.dao.inter.UserSkillDaoInter;
import com.company.resume.etinity.EmploymentHistory;
import com.company.resume.etinity.Skill;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {
        AdminDaoInter adminDao = Context.instanceOfAdminDao();
        UserDaoInter userDao = Context.instanceOfUserDao();
        SkillDaoInter skillDao = Context.instanceOfSkillDao();

        System.out.println(adminDao.getAll(null).get(0).getPassword());
        
        System.out.println(userDao.getUserById(1));
        System.out.println(skillDao.getAll());

    }
}
