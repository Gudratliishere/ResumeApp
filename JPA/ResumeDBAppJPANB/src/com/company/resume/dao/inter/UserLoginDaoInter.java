/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.dao.inter;

import com.company.resume.etinity.UserLogin;
import java.util.List;

/**
 *
 * @author x
 */
public interface UserLoginDaoInter
{
    List<UserLogin> getAll();
    
    UserLogin findLogin(String email);
    
    boolean updateLogin(UserLogin login);
    
    boolean removeLogin(Integer id);
    
    boolean addLogin(UserLogin login);
    
    UserLogin checkPassword(UserLogin login, String password) throws Exception;
}
