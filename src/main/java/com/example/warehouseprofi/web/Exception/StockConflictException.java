package com.example.warehouseprofi.web.Exception;

public class StockConflictException extends RuntimeException {
    public StockConflictException(String message){
        super(message);
    }
}