package com.example.SpringSecurityDataBase.auth;

import com.example.SpringSecurityDataBase.models.ApplicationUser;
import com.example.SpringSecurityDataBase.models.Roles;
import com.example.SpringSecurityDataBase.repo.RoleRepository;
import com.example.SpringSecurityDataBase.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository("fake")
public class ApplicationUserDaoService implements ApplicationUserDao {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public ApplicationUserDaoService(UserRepository userRepository,
                                     RoleRepository roleRepository,
                                     PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(ApplicationUser applicationUser) {
        applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
        Set<Roles> roles = new HashSet<>();
        roles.add(roleRepository.getOne(1L));
        applicationUser.setRoles(roles);
        userRepository.save(applicationUser);
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = userRepository.findAll();
        return applicationUsers;
    }

}
