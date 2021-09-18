package com.edilov.JM9.repository;

import com.edilov.JM9.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
     Role findRoleByRole(String name);
     Role findRoleById(Long id);


}

