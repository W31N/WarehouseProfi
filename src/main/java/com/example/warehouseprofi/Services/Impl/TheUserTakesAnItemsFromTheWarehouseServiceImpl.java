package com.example.warehouseprofi.Services.Impl;

import com.example.warehouseprofi.Controllers.Exception.ItemsConflictException;
import com.example.warehouseprofi.Controllers.Exception.ItemsNotFoundException;
import com.example.warehouseprofi.Dtos.ItemsDto;
import com.example.warehouseprofi.Dtos.TheUserTakesAnItemsFromTheWarehouseDto;
import com.example.warehouseprofi.Repositories.ItemsRepository;
import com.example.warehouseprofi.Repositories.TheUserTakesAnItemsFromTheWarehouseRepository;
import com.example.warehouseprofi.Services.TheUserTakesAnItemsFromTheWarehouseService;
import com.example.warehouseprofi.models.Items;
import com.example.warehouseprofi.models.TheUserTakesAnItemsFromTheWarehouse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TheUserTakesAnItemsFromTheWarehouseServiceImpl implements TheUserTakesAnItemsFromTheWarehouseService {
    @Autowired
    TheUserTakesAnItemsFromTheWarehouseRepository theUserTakesAnItemsFromTheWarehouseRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TheUserTakesAnItemsFromTheWarehouseServiceImpl(TheUserTakesAnItemsFromTheWarehouseRepository theUserTakesAnItemsFromTheWarehouseRepository) {
        this.theUserTakesAnItemsFromTheWarehouseRepository = theUserTakesAnItemsFromTheWarehouseRepository;
    }

    @Override
    public TheUserTakesAnItemsFromTheWarehouseDto register(TheUserTakesAnItemsFromTheWarehouseDto theUserTakesAnItemsFromTheWarehouse) {
        TheUserTakesAnItemsFromTheWarehouse t = modelMapper.map(theUserTakesAnItemsFromTheWarehouse, TheUserTakesAnItemsFromTheWarehouse.class);
        if (t.getId() == null || t.getId() == 0 || get(t.getId()).isEmpty()) {
            return modelMapper.map(theUserTakesAnItemsFromTheWarehouseRepository.save(t), TheUserTakesAnItemsFromTheWarehouseDto.class);
        } else {
            throw new ItemsConflictException("Предметы с такими идентификаторами уже существуют");
        }
    }

    @Override
    public List<TheUserTakesAnItemsFromTheWarehouseDto> getAll() {
        return theUserTakesAnItemsFromTheWarehouseRepository.findAll().stream().map((s) -> modelMapper.map(s, TheUserTakesAnItemsFromTheWarehouseDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<TheUserTakesAnItemsFromTheWarehouseDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(theUserTakesAnItemsFromTheWarehouseRepository.findById(id), TheUserTakesAnItemsFromTheWarehouseDto.class));
    }

    @Override
    public void delete(Long id) {
        if (theUserTakesAnItemsFromTheWarehouseRepository.findById(id).isPresent()) {
            theUserTakesAnItemsFromTheWarehouseRepository.deleteById(id);
        } else {
            throw new ItemsNotFoundException(id);
        }
    }

    @Override
    public TheUserTakesAnItemsFromTheWarehouseDto update(TheUserTakesAnItemsFromTheWarehouseDto theUserTakesAnItemsFromTheWarehouse) {
        if (theUserTakesAnItemsFromTheWarehouseRepository.findById(theUserTakesAnItemsFromTheWarehouse.getId()).isPresent()) {
            return modelMapper.map(theUserTakesAnItemsFromTheWarehouseRepository.save(modelMapper.map(theUserTakesAnItemsFromTheWarehouse, TheUserTakesAnItemsFromTheWarehouse.class)), TheUserTakesAnItemsFromTheWarehouseDto.class);
        } else {
            throw new ItemsNotFoundException(theUserTakesAnItemsFromTheWarehouse.getId());
        }
    }
}