package com.example.warehouseprofi.services.impl;

import com.example.warehouseprofi.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.stream.Collectors;

public class AppUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {



        return userRepository.findByUsername(username)//ТУТ МОЖЕТ БЫТЬ ПРОБЛЕМА
                .map(u -> new User(
                        u.getUsername(),
                        u.getPassword(),
                        Collections.singleton(new SimpleGrantedAuthority("ROLE_" + u.getRole().getName().name()))
                )).orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }


}

