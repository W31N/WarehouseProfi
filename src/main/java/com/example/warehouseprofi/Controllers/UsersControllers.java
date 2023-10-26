package com.example.warehouseprofi.Controllers;

import com.example.warehouseprofi.Controllers.Exception.UsersNotFoundException;
import com.example.warehouseprofi.Dtos.UsersDto;
import com.example.warehouseprofi.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersControllers {
    @Autowired
    private UsersService usersService;
    @GetMapping()
    Iterable<UsersDto> all(){
        return usersService.getAll();
    }
    @GetMapping("/{id}")
    UsersDto get(@PathVariable Long id){
        return usersService.get(id).orElseThrow(() -> new UsersNotFoundException(id));
    }
    @PostMapping
    UsersDto createUsers(@RequestBody UsersDto users){
        return usersService.register(users);
    }
    @DeleteMapping("/{id}")
    void deleteUsers(@PathVariable Long id){
        usersService.delete(id);
    }
    @PutMapping()
    UsersDto update(@RequestBody UsersDto users){
        return usersService.update(users);
    }
}