package com.company.resume.dao;

import com.company.resume.etinity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer>, UserLoginRepositoryCustom
{
    UserLogin findByEmail(String email);
}
