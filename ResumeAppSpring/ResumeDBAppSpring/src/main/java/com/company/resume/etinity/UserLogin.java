/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.etinity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

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
        
        this.password = new BCryptPasswordEncoder().encode(password);
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
        this.password = new BCryptPasswordEncoder().encode(password);
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
