package com.example.warehouseprofi.Repositories;

import com.example.warehouseprofi.models.TheUserTakesAnItemsFromTheWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheUserTakesAnItemsFromTheWarehouseRepository extends JpaRepository<TheUserTakesAnItemsFromTheWarehouse, Long> {
}