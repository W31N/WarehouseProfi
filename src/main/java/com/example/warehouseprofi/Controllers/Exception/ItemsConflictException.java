package com.example.warehouseprofi.Controllers.Exception;

public class ItemsConflictException extends RuntimeException {
    public ItemsConflictException(String message) {
        super(message);
    }
}