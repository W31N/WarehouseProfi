package com.example.warehouseprofi.Controllers.Exception;

public class StockNotFoundException extends RuntimeException{
    public StockNotFoundException(Long id){
        super("Не удалось найти склад "+ id);
    }
}