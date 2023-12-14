package com.example.warehouseprofi.services.impl;

import com.example.warehouseprofi.dtos.add.AddRoleDto;
import com.example.warehouseprofi.dtos.show.ShowRoleDto;
import com.example.warehouseprofi.models.entities.Role;
import com.example.warehouseprofi.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RoleService implements com.example.warehouseprofi.services.RoleService {

    private RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void addRole(AddRoleDto roleDto){
        Role role = modelMapper.map(roleDto, Role.class);
        role.setId(UUID.randomUUID());

        roleRepository.saveAndFlush(role);
    }

    @Override
    public List<ShowRoleDto> allRoles() {
        return roleRepository.findAll().stream().map(role -> modelMapper.map(role, ShowRoleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRole(String roleName) {
        roleRepository.deleteByName(com.example.warehouseprofi.models.enums.Role.valueOf(roleName));
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

}
