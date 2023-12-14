package com.example.warehouseprofi.web.Exception;

public class UsersConflictException extends RuntimeException {
    public UsersConflictException (String message){
        super(message);
    }
}