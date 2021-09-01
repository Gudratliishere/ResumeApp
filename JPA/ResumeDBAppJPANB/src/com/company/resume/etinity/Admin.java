/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.etinity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author x
 */
@Entity
@Table(name = "admin")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a")
    , @NamedQuery(name = "Admin.findById", query = "SELECT a FROM Admin a WHERE a.id = :id")
    , @NamedQuery(name = "Admin.findByEmail", query = "SELECT a FROM Admin a WHERE a.email = :email")
    , @NamedQuery(name = "Admin.findByPassword", query = "SELECT a FROM Admin a WHERE a.password = :password")
    , @NamedQuery(name = "Admin.findByFullName", query = "SELECT a FROM Admin a WHERE a.fullName = :fullName")
})
public class Admin implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String fullName;

    public Admin()
    {
    }

    public Admin(Integer id)
    {
        this.id = id;
    }

    public Admin(Integer id, String email, String password, String fullName)
    {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        
        try
        {
            this.password = DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5")
                    .digest(password.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
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
        try
        {
            this.password = DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5")
                    .digest(password.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin))
            return false;
        Admin other = (Admin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return fullName;
    }
    
}
