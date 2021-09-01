package com.company.resume.service.inter;

import com.company.resume.etinity.Country;
import java.util.List;

public interface CountryServiceInter
{
    List<Country> getAll ();
    
    Country getCountryById (int countryId);
    
    void removeCountry (Country country);
    
    Country saveCountry (Country country);
}
