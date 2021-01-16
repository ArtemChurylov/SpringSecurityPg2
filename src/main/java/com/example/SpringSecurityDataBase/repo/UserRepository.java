package com.example.SpringSecurityDataBase.repo;

import com.example.SpringSecurityDataBase.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {
}
