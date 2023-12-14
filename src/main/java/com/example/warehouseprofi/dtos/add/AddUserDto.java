package com.example.warehouseprofi.dtos.add;

import com.example.warehouseprofi.utils.UniqueUserName;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AddUserDto {

    private String roleName;
    @UniqueUserName
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String warehouseName;

    @NotEmpty(message = "Please choose a role!")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @NotEmpty(message = "Username cannot be null or empty!")
    @Size(min = 2, max = 20, message = "Username must be between 2 and 20 characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotEmpty(message = "First name cannot be null or empty!")
    @Size(min = 2, message = "First name should be at least 2 characters long!")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotEmpty(message = "Last name cannot be null or empty!")
    @Size(min = 2, message = "Last name should be at least 2 characters long!")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @NotEmpty(message = "Password cannot be null or empty!")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty(message = "Please choose a warehouse!")
    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
}
