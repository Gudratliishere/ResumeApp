package com.company.resume.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {
    public static Connection connect () throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String url  = "jdbc:mysql://localhost:3306/resume";
        String name = "root";
        String password = "2002";
        return DriverManager.getConnection(url, name, password);
    }
}
