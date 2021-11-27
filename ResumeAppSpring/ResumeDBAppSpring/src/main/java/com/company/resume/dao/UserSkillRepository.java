package com.company.resume.dao;

import com.company.resume.etinity.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSkillRepository extends JpaRepository<UserSkill, Integer>
        , UserSkillRepositoryCustom
{
}