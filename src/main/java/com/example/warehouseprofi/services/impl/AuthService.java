package com.example.warehouseprofi.services.impl;

import com.example.warehouseprofi.dtos.add.UserRegistrationDto;
import com.example.warehouseprofi.models.entities.User;
import com.example.warehouseprofi.models.enums.Role;
import com.example.warehouseprofi.repositories.RoleRepository;
import com.example.warehouseprofi.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;


    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRegistrationDto registrationDto){
        if(!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())){
            throw new RuntimeException("password.match");
        }

        Optional<User> byUsername = this.userRepository.findByUsername(registrationDto.getUsername());

        if(byUsername.isPresent()){
            throw new RuntimeException("username.used");
        }

        var userRole = roleRepository
                .findByName(Role.USER).orElseThrow();

        User user = new User();

        user.setId(UUID.randomUUID());
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRole(userRole);//Добавить выбор склада

        this.userRepository.save(user);
    }

    public User getUser(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }

}
