package com.example.warehouseprofi.web.Exception;

public class ItemsConflictException extends RuntimeException {
    public ItemsConflictException(String message) {
        super(message);
    }
}