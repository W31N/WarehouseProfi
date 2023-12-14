package com.example.warehouseprofi.web.Exception;

public class StockNotFoundException extends RuntimeException{
    public StockNotFoundException(Long id){
        super("Не удалось найти склад "+ id);
    }
}