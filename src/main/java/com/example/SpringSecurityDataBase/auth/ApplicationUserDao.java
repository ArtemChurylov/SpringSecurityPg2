package com.example.SpringSecurityDataBase.auth;

import com.example.SpringSecurityDataBase.models.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserDao {

    void save(CrmUser crmUser);

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
