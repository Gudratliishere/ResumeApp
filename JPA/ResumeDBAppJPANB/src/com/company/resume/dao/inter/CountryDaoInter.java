package com.company.resume.dao.inter;

import com.company.resume.etinity.Country;
import com.company.resume.etinity.EmploymentHistory;

import java.util.List;

public interface CountryDaoInter {
    List<Country> getAll ();
    
    Country getCountryById (int countryId);
    
    boolean removeCountry (int countryId);
    
    boolean updateCountry (Country country);
    
    boolean addCountry (Country country);
}
