package com.company.resume.dao;

import com.company.resume.etinity.UserSkill;
import java.util.List;

public interface UserSkillRepositoryCustom
{
    List<UserSkill> getAllSkillByUserId (int userId);
}