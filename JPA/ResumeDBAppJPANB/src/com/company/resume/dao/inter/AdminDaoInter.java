package com.company.resume.dao.inter;

import com.company.resume.etinity.Admin;

import java.util.List;

public interface AdminDaoInter {
    List<Admin> getAll(String email);

    boolean updateAdmin(Admin u);

    boolean removeAdmin(int id);

    boolean addAdmin(Admin u);

    Admin getAdminByEmail(String email);
    
    Admin checkPassword(Admin admin, String password) throws Exception;
}
