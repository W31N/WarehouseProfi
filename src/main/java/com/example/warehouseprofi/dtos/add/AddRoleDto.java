package com.example.warehouseprofi.dtos.add;

import com.example.warehouseprofi.models.enums.Role;
import jakarta.validation.constraints.NotNull;

public class AddRoleDto {

    private Role name;

    @NotNull(message = "Please choose a role!")
    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }
}
