package com.company.resume.service.impl;

import com.company.resume.dao.UserRepository;
import com.company.resume.etinity.Country;
import com.company.resume.etinity.User;
import com.company.resume.service.inter.UserServiceInter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter
{

    private final UserRepository userRepository;

    public UserServiceImpl (UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll(String name, String surname, Country nationality)
    {
        return userRepository.getAll(name, surname, nationality);
    }

    @Override
    public User saveUser(User u)
    {
        return userRepository.save(u);
    }

    @Override
    public void removeUser(User u)
    {
        userRepository.delete(u);
    }

    @Override
    public User getUserById(Integer userId)
    {
        return userRepository.findById(userId).orElse(null);
    }
}
