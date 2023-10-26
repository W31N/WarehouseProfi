package com.example.warehouseprofi.Controllers;

import com.example.warehouseprofi.Controllers.Exception.StockNotFoundException;
import com.example.warehouseprofi.Dtos.StockDto;
import com.example.warehouseprofi.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockControllers {

    @Autowired
    private StockService stockService;

    @GetMapping()
    Iterable<StockDto> all() {
        return stockService.getAllStock();
    }

    @GetMapping("/{id}")
    StockDto get(@PathVariable Long id) {
        return stockService.getStockById(id).orElseThrow(() -> new StockNotFoundException(id));
    }

    @PostMapping()
    StockDto createStock(@RequestBody StockDto stock) {
        return stockService.register(stock);
    }

    @DeleteMapping("/{id}")
    void deleteStock(@PathVariable Long id) {
        stockService.delete(id);
    }

    @PutMapping()
    StockDto update(@RequestBody StockDto stock) {
        return stockService.update(stock);
    }
}