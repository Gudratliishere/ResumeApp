package com.company.resume.service.inter;

import com.company.resume.etinity.Skill;

import java.util.List;

public interface SkillServiceInter
{
    List<Skill> getAll ();
    
    Skill getSkillById(Integer skillId);
    
    Skill updateSkill (Skill skill);
    
    void removeSkill (Skill skill);
            
    Skill addSkill (Skill skill);     
    
    boolean existSkill (Skill skill);
}
