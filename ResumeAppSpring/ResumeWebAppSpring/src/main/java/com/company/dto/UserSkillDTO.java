package com.company.dto;

import com.company.resume.etinity.UserSkill;
import com.company.resume.service.inter.SkillServiceInter;
import com.company.resume.service.inter.UserSkillServiceInter;

/**
 *
 * @author x
 */
public class UserSkillDTO
{

    Integer id;
    SkillDTO skill;
    Integer power;

    public UserSkillDTO()
    {
    }

    public UserSkillDTO(SkillDTO skill, Integer power, Integer id)
    {
        this.skill = skill;
        this.power = power;
        this.id = id;
    }
    
    public static UserSkillDTO of (UserSkill userSkill)
    {
        return new UserSkillDTO(SkillDTO.of(userSkill.getSkill()), userSkill.getPower(), userSkill.getId());
    }
    
    public static UserSkill toUserSkill(UserSkillDTO userSkillDTO, UserSkillServiceInter userSkillService, 
            SkillServiceInter skillService)
    {
        UserSkill userSkill = userSkillService.getUserSkillById(userSkillDTO.getId());
        
        userSkill.setPower(userSkillDTO.getPower());
        userSkill.setSkill(SkillDTO.toSkill(userSkillDTO.getSkill(), skillService));
        
        return userSkill;
    }

    public SkillDTO getSkill()
    {
        return skill;
    }

    public void setSkill(SkillDTO skill)
    {
        this.skill = skill;
    }

    public Integer getPower()
    {
        return power;
    }

    public void setPower(Integer power)
    {
        this.power = power;
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
        return skill.name;
    }
}
