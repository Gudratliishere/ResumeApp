/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.etinity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author x
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
    , @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name")
    , @NamedQuery(name = "User.findBySurname", query = "SELECT u FROM User u WHERE u.surname = :surname")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
    , @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone")
    , @NamedQuery(name = "User.findByAdress", query = "SELECT u FROM User u WHERE u.adress = :adress")
    , @NamedQuery(name = "User.findByBirthdate", query = "SELECT u FROM User u WHERE u.birthdate = :birthdate")
})
public class User implements Serializable
{

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserLogin> userLoginList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Lob
    @Column(name = "profile_description")
    private String profileDescription;
    @Column(name = "adress")
    private String adress;
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @OneToMany(mappedBy = "user")
    private List<UserSkill> userSkillList;
    @OneToMany(mappedBy = "user")
    private List<EmploymentHistory> employmentHistoryList;
    @JoinColumn(name = "birthplace_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Country birthplace;
    @JoinColumn(name = "nationality_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Country nationality;

    public User()
    {
    }

    public User(Integer id)
    {
        this.id = id;
    }

    public User(Integer id, String name, String surname, String email, String phone)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public User(Integer id, String name, String surname, String email, String phone, String profileDescription, String adress, Date birthdate, Country birthplace, Country nationality)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.profileDescription = profileDescription;
        this.adress = adress;
        this.birthdate = birthdate;
        this.birthplace = birthplace;
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getProfileDescription()
    {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription)
    {
        this.profileDescription = profileDescription;
    }

    public String getAdress()
    {
        return adress;
    }

    public void setAdress(String adress)
    {
        this.adress = adress;
    }

    public Date getBirthdate()
    {
        return birthdate;
    }

    public void setBirthdate(Date birthdate)
    {
        this.birthdate = birthdate;
    }

    @XmlTransient
    public List<UserSkill> getUserSkillList()
    {
        return userSkillList;
    }

    public void setUserSkillList(List<UserSkill> userSkillList)
    {
        this.userSkillList = userSkillList;
    }

    @XmlTransient
    public List<EmploymentHistory> getEmploymentHistoryList()
    {
        return employmentHistoryList;
    }

    public void setEmploymentHistoryList(List<EmploymentHistory> employmentHistoryList)
    {
        this.employmentHistoryList = employmentHistoryList;
    }

    public Country getBirthplace()
    {
        return birthplace;
    }

    public void setBirthplace(Country birthplace)
    {
        this.birthplace = birthplace;
    }

    public Country getNationality()
    {
        return nationality;
    }

    public void setNationality(Country nationality)
    {
        this.nationality = nationality;
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
        if (!(object instanceof User))
            return false;
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return name + " " + surname;
    }

    @XmlTransient
    public List<UserLogin> getUserLoginList()
    {
        return userLoginList;
    }

    public void setUserLoginList(List<UserLogin> userLoginList)
    {
        this.userLoginList = userLoginList;
    }
    
}
