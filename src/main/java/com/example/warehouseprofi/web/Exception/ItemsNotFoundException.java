package com.example.warehouseprofi.web.Exception;

public class ItemsNotFoundException extends RuntimeException{
    public ItemsNotFoundException(Long id) {
        super("Не удалось найти предметы " + id);
    }
}