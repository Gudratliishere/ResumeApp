package com.company.resume.etinity;

import com.company.resume.etinity.Country;
import com.company.resume.etinity.EmploymentHistory;
import com.company.resume.etinity.UserLogin;
import com.company.resume.etinity.UserSkill;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-19T19:48:45")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Date> birthdate;
    public static volatile SingularAttribute<User, String> profileDescription;
    public static volatile SingularAttribute<User, String> adress;
    public static volatile ListAttribute<User, EmploymentHistory> employmentHistoryList;
    public static volatile ListAttribute<User, UserLogin> userLoginList;
    public static volatile SingularAttribute<User, Country> birthplace;
    public static volatile SingularAttribute<User, Country> nationality;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile ListAttribute<User, UserSkill> userSkillList;

}