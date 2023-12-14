package com.example.warehouseprofi.services.impl;

import com.example.warehouseprofi.dtos.add.AddUserDto;
import com.example.warehouseprofi.dtos.show.ShowUserDto;
import com.example.warehouseprofi.models.entities.User;
import com.example.warehouseprofi.models.enums.Role;
import com.example.warehouseprofi.repositories.RoleRepository;
import com.example.warehouseprofi.repositories.UserRepository;
import com.example.warehouseprofi.repositories.WarehouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements com.example.warehouseprofi.services.UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private WarehouseRepository warehouseRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addUser(AddUserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        String password = userDto.getPassword();
        user.setId(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(roleRepository.findByName(Role.valueOf(userDto.getRoleName())).orElse(null));
        user.setWarehouse(warehouseRepository.findByName(userDto.getWarehouseName()).orElse(null));

        userRepository.saveAndFlush(user);
    }

    @Override
    public List<ShowUserDto> allUsers(){
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, ShowUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(String username){
        userRepository.deleteByUsername(username);
    }


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setWarehouseRepository(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
