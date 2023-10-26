package com.example.warehouseprofi.Services;

import com.example.warehouseprofi.Dtos.TheUserTakesAnItemsFromTheWarehouseDto;

import java.util.List;
import java.util.Optional;

public interface TheUserTakesAnItemsFromTheWarehouseService {
    TheUserTakesAnItemsFromTheWarehouseDto register(TheUserTakesAnItemsFromTheWarehouseDto theUserTakesAnItemsFromTheWarehouse);

    List<TheUserTakesAnItemsFromTheWarehouseDto> getAll();

    Optional<TheUserTakesAnItemsFromTheWarehouseDto> get(Long id);

    void delete(Long id);

    TheUserTakesAnItemsFromTheWarehouseDto update(TheUserTakesAnItemsFromTheWarehouseDto theUserTakesAnItemsFromTheWarehouse);
}