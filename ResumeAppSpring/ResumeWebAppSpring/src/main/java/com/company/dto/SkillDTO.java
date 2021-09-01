package com.company.dto;

import com.company.resume.dao.SkillRepository;
import com.company.resume.etinity.Skill;
import com.company.resume.service.inter.SkillServiceInter;

/**
 *
 * @author x
 */
public class SkillDTO
{

    Integer id;
    String name;

    public SkillDTO()
    {
    }

    public SkillDTO(String name, Integer id)
    {
        this.name = name;
        this.id = id;
    }
    
    
    public static SkillDTO of (Skill skill)
    {
        return new SkillDTO(skill.getName(), skill.getId());
    }
    
    public static Skill toSkill(SkillDTO skillDTO, SkillServiceInter skillService)
    {
        Skill skill = skillService.getSkillById(skillDTO.getId());
        
        return skill;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
    
    @Override
    public String toString()
    {
        return "SkillDTO{" + "name=" + name + '}';
    }
}
