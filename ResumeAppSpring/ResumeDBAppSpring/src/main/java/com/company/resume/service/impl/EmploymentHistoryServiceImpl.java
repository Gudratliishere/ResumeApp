package com.company.resume.service.impl;

import com.company.resume.dao.EmploymentHistoryRepository;
import com.company.resume.etinity.EmploymentHistory;
import com.company.resume.service.inter.EmploymentHistoryServiceInter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmploymentHistoryServiceImpl implements EmploymentHistoryServiceInter
{

    private final EmploymentHistoryRepository employmentHistoryRepository;

    public EmploymentHistoryServiceImpl (EmploymentHistoryRepository employmentHistoryRepository)
    {
        this.employmentHistoryRepository = employmentHistoryRepository;
    }

    @Override
    public void removeEmploymentHistory(EmploymentHistory eh)
    {
        employmentHistoryRepository.delete(eh);
    }

    @Override
    public EmploymentHistory saveEmploymentHistory(EmploymentHistory eh)
    {
        return employmentHistoryRepository.save(eh);
    }

    @Override
    public EmploymentHistory getEmploymentHistoryById(Integer id)
    {
        return employmentHistoryRepository.findById(id).orElse(null);
    }
}
