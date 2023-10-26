package com.example.warehouseprofi.Controllers.Exception;

public class StockConflictException extends RuntimeException {
    public StockConflictException(String message){
        super(message);
    }
}