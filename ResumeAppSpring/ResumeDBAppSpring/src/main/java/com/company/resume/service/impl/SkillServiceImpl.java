package com.company.resume.service.impl;

import com.company.resume.dao.SkillRepository;
import com.company.resume.etinity.Skill;
import com.company.resume.service.inter.SkillServiceInter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillServiceImpl implements SkillServiceInter
{

    private final SkillRepository skillRepository;

    public SkillServiceImpl (SkillRepository skillRepository)
    {
        this.skillRepository = skillRepository;
    }

    @Override
    public List<Skill> getAll() {
        return skillRepository.findAll();
    }

    @Override
    public Skill getSkillById(Integer skillId) {
        return skillRepository.findById(skillId).orElse(null);

    }

    @Override
    public Skill updateSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public void removeSkill(Skill skill) {
        skillRepository.delete(skill);
    }

    @Override
    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public boolean existSkill(Skill skill)
    {
        return skillRepository.existsById(skill.getId());
    }
}
