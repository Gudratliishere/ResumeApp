package com.company.resume.service.impl;

import com.company.resume.dao.UserSkillRepository;
import com.company.resume.etinity.UserSkill;
import com.company.resume.service.inter.UserSkillServiceInter;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserSkillServiceImpl implements UserSkillServiceInter
{

    private final UserSkillRepository userSkillRepository;

    public UserSkillServiceImpl(UserSkillRepository userSkillRepository)
    {
        this.userSkillRepository = userSkillRepository;
    }
    
    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        return userSkillRepository.getAllSkillByUserId(userId);
    }

    @Override
    public UserSkill saveUserSkill(UserSkill userSkill)
    {
        return userSkillRepository.save(userSkill);
    }

    @Override
    public void removeUserSkill(UserSkill userSkill)
    {
        userSkillRepository.delete(userSkill);
    }

    @Override
    public UserSkill getUserSkillById(Integer id)
    {
        return userSkillRepository.findById(id).orElse(null);
    }
}
