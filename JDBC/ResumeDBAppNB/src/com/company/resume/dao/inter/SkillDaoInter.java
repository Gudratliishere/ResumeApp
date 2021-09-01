package com.company.resume.dao.inter;

import com.company.resume.etinity.EmploymentHistory;
import com.company.resume.etinity.Skill;

import java.util.List;

public interface SkillDaoInter {
    List<Skill> getAll ();
    
    Skill getSkillById(int skillId);
    
    boolean updateSkill (Skill skill);
    
    boolean removeSkill (int skillId);
            
    boolean addSkill (Skill skill);     
    
    boolean existSkill (Skill skill);
}
