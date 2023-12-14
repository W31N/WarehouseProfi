package com.example.warehouseprofi.services;


import com.example.warehouseprofi.dtos.add.AddWarehouseDto;
import com.example.warehouseprofi.dtos.show.ShowWarehouseDto;

import java.util.List;

public interface WarehouseService {

    void addWarehouse(AddWarehouseDto warehouseDto);

    List<ShowWarehouseDto> allWarehouses();

    void deleteWarehouse(String name);


}
