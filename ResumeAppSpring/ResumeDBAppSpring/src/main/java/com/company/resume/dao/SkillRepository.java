package com.company.resume.dao;

import com.company.resume.etinity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer>
{
}