package com.company.resume.dao;

import com.company.resume.etinity.EmploymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentHistoryRepository extends JpaRepository<EmploymentHistory, Integer>
{
}