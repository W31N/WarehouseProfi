package com.example.warehouseprofi.Repositories;

import com.example.warehouseprofi.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}