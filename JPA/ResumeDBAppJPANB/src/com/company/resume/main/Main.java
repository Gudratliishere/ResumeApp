package com.company.resume.main;

import com.company.resume.dao.inter.AdminDaoInter;

public class Main
{

    public static void main(String[] args)
    {
        AdminDaoInter adminDao = Context.instanceOfAdminDao();

        System.out.println(adminDao.getAll(null));
    }
}
