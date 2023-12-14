package com.example.warehouseprofi.services;

import com.example.warehouseprofi.dtos.add.AddRoleDto;
import com.example.warehouseprofi.dtos.show.ShowRoleDto;

import java.util.List;

public interface RoleService {

    void addRole(AddRoleDto roleDto);
    void deleteRole(String roleName);
    List<ShowRoleDto> allRoles();

}
