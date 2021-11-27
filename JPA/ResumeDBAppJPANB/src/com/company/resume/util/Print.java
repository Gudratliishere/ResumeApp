package com.company.resume.util;

import com.company.resume.etinity.User;

import java.util.List;

public class Print {
    public static void printArray (List<User> list)
    {
        System.out.println("--------------------");
        for (User u: list)
        {
            System.out.println("id = " + u.getId());
            System.out.println("name = " + u.getName());
            System.out.println("surname = " + u.getSurname());
            System.out.println("email = " + u.getEmail());
            System.out.println("phone = " + u.getPhone());
            System.out.println("-------------------------");
        }
    }
}
