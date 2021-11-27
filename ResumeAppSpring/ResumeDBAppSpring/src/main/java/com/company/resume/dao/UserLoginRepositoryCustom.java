package com.company.resume.dao;

import com.company.resume.etinity.UserLogin;
import java.util.List;

public interface UserLoginRepositoryCustom
{
    List<UserLogin> getAll();
    
    UserLogin checkPassword(UserLogin login, String password) throws Exception;
}
