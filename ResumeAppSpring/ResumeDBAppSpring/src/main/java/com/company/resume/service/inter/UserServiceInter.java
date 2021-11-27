package com.company.resume.service.inter;

import com.company.resume.etinity.Country;
import com.company.resume.etinity.User;

import java.util.List;

public interface UserServiceInter
{
    List<User> getAll(String name, String surname, Country nationality);

    User saveUser(User u);

    void removeUser(User u);

    User getUserById(Integer id);
}
