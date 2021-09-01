package com.company.resume.dao.inter;

import com.company.resume.etinity.EmploymentHistory;
import com.company.resume.etinity.UserSkill;

import java.util.List;

public interface EmploymentHistoryDaoInter {
    List<EmploymentHistory> getAllEmploymentHistoryByUserId (int userId);
    
    boolean removeEmploymentHistory (int ehId);
    
    boolean updateEmploymentHistory (EmploymentHistory eh);
    
    boolean addEmploymentHistory (EmploymentHistory eh);
}
