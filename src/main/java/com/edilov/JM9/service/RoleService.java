package com.edilov.JM9.service;

import com.edilov.JM9.entity.Role;
import com.edilov.JM9.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findRoleById(id);
    }
    public Role getRoleByName(String name) {
        return roleRepository.findRoleByRole(name);
    }

    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}