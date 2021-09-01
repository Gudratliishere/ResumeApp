package com.company.resume.service.impl;

import com.company.resume.dao.CountryRepository;
import com.company.resume.etinity.Country;
import com.company.resume.service.inter.CountryServiceInter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryServiceInter
{

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository)
    {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAll()
    {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(int countryId)
    {
        return countryRepository.findById(countryId).orElse(null);
    }

    @Override
    public void removeCountry(Country country)
    {
        countryRepository.delete(country);
    }

    @Override
    public Country saveCountry(Country country)
    {
        return countryRepository.save(country);
    }
}
