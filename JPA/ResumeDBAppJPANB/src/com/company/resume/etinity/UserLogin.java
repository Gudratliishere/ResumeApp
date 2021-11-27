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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "user_login")
@XmlRootElement
@NamedQueries(
        {
            @NamedQuery(name = "UserLogin.findAll", query = "SELECT u FROM UserLogin u")
            , @NamedQuery(name = "UserLogin.findById", query = "SELECT u FROM UserLogin u WHERE u.id = :id")
            , @NamedQuery(name = "UserLogin.findByEmail", query = "SELECT u FROM UserLogin u WHERE u.email = :email")
            , @NamedQuery(name = "UserLogin.findByPassword", query = "SELECT u FROM UserLogin u WHERE u.password = :password")
        })
public class UserLogin implements Serializable
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
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

    public UserLogin()
    {
    }

    public UserLogin(Integer id)
    {
        this.id = id;
    }

    public UserLogin(Integer id, String email, String password)
    {
        this.id = id;
        this.email = email;
        
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

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
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
        if (!(object instanceof UserLogin))
            return false;
        UserLogin other = (UserLogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return email;
    }

}
