package com.example.warehouseprofi.Services;

import com.example.warehouseprofi.Dtos.StockDto;

import java.util.List;
import java.util.Optional;

public interface StockService {
    StockDto register(StockDto stock);
    Optional<StockDto> getStockById(Long id);
    List<StockDto> getAllStock();
    void delete(Long id);
    StockDto update(StockDto stock);
}
