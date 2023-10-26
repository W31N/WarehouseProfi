package com.example.warehouseprofi.Services.Impl;

import com.example.warehouseprofi.Controllers.Exception.StockConflictException;
import com.example.warehouseprofi.Controllers.Exception.StockNotFoundException;
import com.example.warehouseprofi.Dtos.StockDto;
import com.example.warehouseprofi.Repositories.StockRepository;
import com.example.warehouseprofi.Services.StockService;
import com.example.warehouseprofi.models.Stock;
import jakarta.persistence.Entity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StockDto register(StockDto stock) {
        Stock s = modelMapper.map(stock, Stock.class);
        if (s.getId() == null || s.getId() == 0 || getStockById(s.getId()).isEmpty()) {
            return modelMapper.map(stockRepository.save(s), StockDto.class);
        } else {
            throw new StockConflictException("Склад с таким идентификатором уже существует");
        }
    }
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public StockDto update(StockDto stock) {
        if (stockRepository.findById(stock.getId()).isPresent()) {
            return modelMapper.map(stockRepository.save(modelMapper.map(stock, Stock.class)), StockDto.class);
        } else {
            throw new StockNotFoundException(stock.getId());
        }
    }

    @Override
    public Optional<StockDto> getStockById(Long id) {
        return Optional.ofNullable(modelMapper.map(stockRepository.findById(id),StockDto.class));
    }

    @Override
    public List<StockDto> getAllStock() {
        return stockRepository.findAll().stream().map((s) -> modelMapper.map(s, StockDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (stockRepository.findById(id).isPresent()) {
            stockRepository.deleteById(id);
        } else {
            throw new StockNotFoundException(id);
        }
    }
}