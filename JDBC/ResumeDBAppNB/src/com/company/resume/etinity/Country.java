package com.company.resume.etinity;

import java.util.Objects;

public class Country {
    private int id;
    private String name;
    private String nationality;

    public Country() {
    }

    public Country(int id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return name + " (" + nationality + ")";
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.nationality);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        final Country other = (Country) obj;
        if (this.id == other.id)
        {
            return true;
        }
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        if (this.id != other.id)
        {
            return false;
        }
        
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.nationality, other.nationality))
        {
            return false;
        }
        return true;
    }
    
    
}
