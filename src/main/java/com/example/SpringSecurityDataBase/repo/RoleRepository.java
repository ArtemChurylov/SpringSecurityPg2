package com.example.SpringSecurityDataBase.repo;

import com.example.SpringSecurityDataBase.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
}
