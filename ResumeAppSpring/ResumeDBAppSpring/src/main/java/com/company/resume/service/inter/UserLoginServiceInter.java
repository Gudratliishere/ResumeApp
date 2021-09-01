/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.service.inter;

import com.company.resume.etinity.UserLogin;

import java.util.List;

/**
 *
 * @author x
 */
public interface UserLoginServiceInter
{
    List<UserLogin> getAll();
    
    UserLogin findLogin(String email);
    
    void removeLogin(UserLogin login);
    
    UserLogin saveLogin(UserLogin login);
    
    UserLogin checkPassword(UserLogin login, String password) throws Exception;
}
