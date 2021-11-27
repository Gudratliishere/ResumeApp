package com.company.dto;

import com.company.resume.dao.CountryRepository;
import com.company.resume.etinity.Country;
import com.company.resume.service.inter.CountryServiceInter;

/**
 *
 * @author x
 */
public class CountryDTO
{
    Integer id;
    String name;
    String nationality;
    
    public CountryDTO()
    {
    }

    public CountryDTO(String name, String nationality, Integer id)
    {
        this.name = name;
        this.nationality = nationality;
        this.id = id;
    }
    
    public static CountryDTO of (Country country)
    {
        return new CountryDTO(country.getName(), country.getNationality(), country.getId());
    }
    
    public static Country toCountry (CountryDTO countryDTO, CountryServiceInter countryService)
    {
        Country country = countryService.getCountryById(countryDTO.getId());
        
        return country;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNationality()
    {
        return nationality;
    }

    public void setNationality(String nationality)
    {
        this.nationality = nationality;
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
        return "CountryDTO{" + "name=" + name + ", nationality=" + nationality + '}';
    }
}
