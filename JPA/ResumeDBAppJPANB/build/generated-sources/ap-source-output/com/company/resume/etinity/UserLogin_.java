package com.company.resume.etinity;

import com.company.resume.etinity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-19T19:48:45")
@StaticMetamodel(UserLogin.class)
public class UserLogin_ { 

    public static volatile SingularAttribute<UserLogin, String> password;
    public static volatile SingularAttribute<UserLogin, Integer> id;
    public static volatile SingularAttribute<UserLogin, User> user;
    public static volatile SingularAttribute<UserLogin, String> email;

}