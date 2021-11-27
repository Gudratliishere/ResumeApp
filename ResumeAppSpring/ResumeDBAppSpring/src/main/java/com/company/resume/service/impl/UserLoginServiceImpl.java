package com.company.resume.service.impl;

import com.company.resume.dao.UserLoginRepository;
import com.company.resume.etinity.UserLogin;
import com.company.resume.service.inter.UserLoginServiceInter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginServiceInter
{

    private final UserLoginRepository userLoginRepository;

    public UserLoginServiceImpl (UserLoginRepository userLoginRepository)
    {
        this.userLoginRepository = userLoginRepository;
    }

    @Override
    public List<UserLogin> getAll()
    {
        return userLoginRepository.findAll();
    }

    @Override
    public UserLogin findLogin(String email)
    {
        return userLoginRepository.findByEmail(email);
    }

    @Override
    public void removeLogin(UserLogin login)
    {
        userLoginRepository.delete(login);
    }

    @Override
    public UserLogin saveLogin(UserLogin login)
    {
        return userLoginRepository.save(login);
    }

    @Override
    public UserLogin checkPassword(UserLogin login, String password) throws Exception
    {
        return userLoginRepository.checkPassword(login, password);
    }
    
}