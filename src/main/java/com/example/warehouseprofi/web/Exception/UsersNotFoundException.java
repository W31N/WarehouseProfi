package com.example.warehouseprofi.web.Exception;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException (Long id){
        super("Не удалось найти пользователей " + id);
    }
}