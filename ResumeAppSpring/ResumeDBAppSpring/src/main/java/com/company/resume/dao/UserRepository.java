package com.company.resume.dao;

import com.company.resume.etinity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom
{
    
}