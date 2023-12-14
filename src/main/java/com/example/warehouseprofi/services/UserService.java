package com.example.warehouseprofi.services;

import com.example.warehouseprofi.dtos.add.AddUserDto;
import com.example.warehouseprofi.dtos.show.ShowUserDto;

import java.util.List;

public interface UserService {
    void addUser(AddUserDto userDto);
    List<ShowUserDto> allUsers();
    void deleteUser(String username);
}