package com.company.resume.dao.impl;

import com.company.resume.dao.inter.AbstractDAO;
import com.company.resume.dao.inter.CountryDaoInter;
import com.company.resume.etinity.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter
{

    private Country getCountry(ResultSet rs) throws SQLException
    {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");

        return new Country(id, name, nationality);
    }

    @Override
    public List<Country> getAll()
    {
        List<Country> countries = new ArrayList<>();

        try (Connection c = connect())
        {
            Statement stmt = c.createStatement();
            stmt.execute("select * from country");
            ResultSet rs = stmt.getResultSet();

            while (rs.next())
            {
                countries.add(getCountry(rs));
            }
        } catch (Exception ex)
        {
            System.out.println("Error\n" + ex.getMessage());
        }

        return countries;
    }

    @Override
    public Country getCountryById(int countryId)
    {
        Country country = null;

        try (Connection connect = connect())
        {
            Statement stmt = connect.createStatement();
            stmt.execute("select * from country where id = " + countryId);
            ResultSet rs = stmt.getResultSet();

            while (rs.next())
            {
                String name = rs.getString("name");
                String nationality = rs.getString("nationality");
                country = new Country(1, name, nationality);
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return country;
    }

    @Override
    public boolean removeCountry(int countryId)
    {
        try (Connection connect = connect())
        {
            Statement stmt = connect.createStatement();
            return !stmt.execute("delete from country where id = " + countryId);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateCountry(Country country)
    {
        try (Connection connect = connect())
        {
            PreparedStatement stmt = connect.prepareStatement("update country set name = ?, nationality = ?");
            stmt.setString(1, country.getName());
            stmt.setString(2, country.getNationality());
            return !stmt.execute();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean addCountry(Country country)
    {
        try (Connection connect = connect())
        {
            PreparedStatement stmt = connect.prepareStatement("insert into country(name, nationality) values(?,?)");
            return !stmt.execute();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
