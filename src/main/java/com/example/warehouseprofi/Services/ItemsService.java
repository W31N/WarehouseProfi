package com.example.warehouseprofi.Services;

import com.example.warehouseprofi.Dtos.ItemsDto;

import java.util.List;
import java.util.Optional;

public interface ItemsService {
    ItemsDto register(ItemsDto items);

    List<ItemsDto> getAll();

    Optional<ItemsDto> get(Long id);

    void delete(Long id);

    ItemsDto update(ItemsDto items);

    List<ItemsDto>findItemsByName(String item_name);

    List<ItemsDto>findItemsByUsersName(String status);

    List<ItemsDto> findItemsByStockAddress(String warehouse_address);
}