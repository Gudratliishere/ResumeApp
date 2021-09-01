package com.company.resume.dao;

import com.company.resume.etinity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer>
{
}