package com.company.resume.dao;

import com.company.resume.etinity.Country;
import com.company.resume.etinity.User;
import java.util.List;
import org.springframework.stereotype.Repository;

public interface UserRepositoryCustom {
    List<User> getAll(String name, String surname, Country nid);
}
