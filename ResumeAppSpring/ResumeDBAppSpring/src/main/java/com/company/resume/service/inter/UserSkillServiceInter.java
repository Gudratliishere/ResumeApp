package com.company.resume.service.inter;

import com.company.resume.etinity.UserSkill;
import java.util.List;

public interface UserSkillServiceInter
{
    List<UserSkill> getAllSkillByUserId (int userId);
    
    UserSkill saveUserSkill (UserSkill userSkill);
    
    void removeUserSkill (UserSkill userSkill);
    
    UserSkill getUserSkillById (Integer id);
}