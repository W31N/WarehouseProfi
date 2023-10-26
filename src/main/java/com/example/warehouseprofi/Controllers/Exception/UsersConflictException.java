package com.example.warehouseprofi.Controllers.Exception;

public class UsersConflictException extends RuntimeException {
    public UsersConflictException (String message){
        super(message);
    }
}