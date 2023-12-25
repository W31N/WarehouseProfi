package com.example.warehouseprofi.Init;

import com.example.warehouseprofi.models.entities.Role;
import com.example.warehouseprofi.models.entities.User;
import com.example.warehouseprofi.repositories.RoleRepository;
import com.example.warehouseprofi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Main implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final String defaultPassword;

    public Main(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, @Value("${app.default.password}") String defaultPassword) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.defaultPassword = defaultPassword;
    }

    @Override
    public void run(String... args) {
        initRoles();
        initUsers();
    }

    private void initRoles(){
        if (roleRepository.count() == 0){
            var adminRole = new Role();
            adminRole.setId(UUID.randomUUID());
            adminRole.setName(com.example.warehouseprofi.models.enums.Role.ADMIN);
            var normalUserRole = new Role();
            normalUserRole.setId(UUID.randomUUID());
            normalUserRole.setName(com.example.warehouseprofi.models.enums.Role.USER);
            roleRepository.save(adminRole);
            roleRepository.save(normalUserRole);
        }
    }

    private void initUsers(){
        if (userRepository.count() == 0){
            initAdmin();
            initNormalUser();
        }
    }

    private void initAdmin() {
        var adminRole = roleRepository.findByName(com.example.warehouseprofi.models.enums.Role.ADMIN).orElseThrow();

        var adminUser = new User();
        adminUser.setId(UUID.randomUUID());
        adminUser.setFirstName("Admin");
        adminUser.setLastName("Adminovich");
        adminUser.setUsername("admin");
        adminUser.setPassword(passwordEncoder.encode(defaultPassword));
        adminUser.setRole(adminRole);

        userRepository.save(adminUser);
    }

    private void initNormalUser(){
        var userRole = roleRepository.findByName(com.example.warehouseprofi.models.enums.Role.USER).orElseThrow();

        var normalUser = new User();
        normalUser.setId(UUID.randomUUID());
        normalUser.setFirstName("User");
        normalUser.setLastName("Userovich");
        normalUser.setUsername("user");
        normalUser.setPassword(passwordEncoder.encode(defaultPassword));
        normalUser.setRole(userRole);

        userRepository.save(normalUser);
    }

}