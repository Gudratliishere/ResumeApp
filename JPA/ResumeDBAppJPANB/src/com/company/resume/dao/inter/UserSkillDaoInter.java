package com.company.resume.dao.inter;

import com.company.resume.etinity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {
    List<UserSkill> getAllSkillByUserId (int userId);
    
    boolean updateUserSkill (UserSkill userSkill);
    
    boolean removeUserSkill (int userSkillId);
    
    boolean addUserSkill (UserSkill userSkill);
}