package com.company.resume.dao.inter;

import com.company.resume.etinity.Country;
import com.company.resume.etinity.User;

import java.util.List;

public interface UserDaoInter {
    List<User> getAll(String name, String surname, Country nid);

    boolean updateUser(User u);

    boolean removeUser(int id);

    boolean addUser(User u);

    User getUserById(int id);
}
