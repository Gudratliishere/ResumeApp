package com.company.resume.service.inter;

import com.company.resume.etinity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryServiceInter
{
    void removeEmploymentHistory (EmploymentHistory eh);
    
    EmploymentHistory saveEmploymentHistory (EmploymentHistory eh);
    
    EmploymentHistory getEmploymentHistoryById (Integer id);
}
