/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

import com.company.resume.etinity.EmploymentHistory;
import com.company.resume.service.inter.EmploymentHistoryServiceInter;
import java.util.Date;

/**
 *
 * @author x
 */
public class EmploymentHistoryDTO
{

    Integer id;
    String header;
    Date begindate;
    Date enddate;
    String jobDescription;

    public EmploymentHistoryDTO()
    {
    }

    public EmploymentHistoryDTO(String header, Date begindate, Date enddate, String jobDescription, Integer id)
    {
        this.header = header;
        this.begindate = begindate;
        this.enddate = enddate;
        this.jobDescription = jobDescription;
        this.id = id;
    }

    public static EmploymentHistoryDTO of(EmploymentHistory emp)
    {
        return new EmploymentHistoryDTO(emp.getHeader(), emp.getBeginDate(), emp.getEndDate(), emp.getJobDescription(),
                emp.getId());
    }

    public static EmploymentHistory toEmph(EmploymentHistoryDTO empDTO, EmploymentHistoryServiceInter emphService)
    {
        EmploymentHistory emp = emphService.getEmploymentHistoryById(empDTO.getId());
        
        emp.setHeader(empDTO.getHeader());
        emp.setBeginDate(empDTO.getBegindate());
        emp.setEndDate(empDTO.getEnddate());
        emp.setJobDescription(empDTO.getJobDescription());
        
        return emp;
    }

    public String getHeader()
    {
        return header;
    }

    public void setHeader(String header)
    {
        this.header = header;
    }

    public Date getBegindate()
    {
        return begindate;
    }

    public void setBegindate(Date begindate)
    {
        this.begindate = begindate;
    }

    public Date getEnddate()
    {
        return enddate;
    }

    public void setEnddate(Date enddate)
    {
        this.enddate = enddate;
    }

    public String getJobDescription()
    {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription)
    {
        this.jobDescription = jobDescription;
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
        return "EmploymentHistoryDTO{" + "header=" + header + ", begindate=" + begindate + ", enddate=" + enddate + ", jobDescription=" + jobDescription + '}';
    }
}
