/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.etinity;

/**
 *
 * @author x
 */
public class Admin
{
    private Integer id;
    private String fullName;
    private String email;
    private String password;

    public Admin()
    {
    }

    public Admin(Integer id, String fullName, String email, String password)
    {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
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
        return email;
    }
}
