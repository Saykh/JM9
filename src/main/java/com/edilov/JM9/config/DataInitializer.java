package com.edilov.JM9.config;

import com.edilov.JM9.entity.Role;
import com.edilov.JM9.entity.User;
import com.edilov.JM9.service.RoleService;
import com.edilov.JM9.service.UserService;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final UserService userService;
    private final RoleService roleService;

    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void init() {
        Role role1 = new Role();
        Role role2 = new Role();
        role1.setRole("ROLE_ADMIN");
        role2.setRole("ROLE_USER");
        roleService.saveRole(role1);
        roleService.saveRole(role2);

        User user = new User();
        user.setName("Saykhan");
        user.setLastName("Edilov");
        user.setAge(27);
        user.setEmail("edilov_st@mail.ru");
        user.setUsername("Messi");
        user.setPassword("12345");
        String[] adminRoles = {"ROLE_ADMIN", "ROLE USER"};
        user.setRoles(adminRoles);
        userService.save(user);

        User user2 = new User();
        user2.setName("Muslim");
        user2.setLastName("Isaev");
        user2.setAge(26);
        user2.setEmail("isaev_mv@mail.ru");
        user2.setUsername("Xavi");
        user2.setPassword("1234");
        String[] userRoles = {"ROLE USER"};
        user.setRoles(userRoles);
        userService.save(user2);
    }
}
