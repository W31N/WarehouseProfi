package com.example.warehouseprofi.services.impl;

import com.example.warehouseprofi.dtos.add.AddWarehouseDto;
import com.example.warehouseprofi.dtos.show.ShowWarehouseDto;
import com.example.warehouseprofi.models.entities.Warehouse;
import com.example.warehouseprofi.repositories.WarehouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class WarehouseService implements com.example.warehouseprofi.services.WarehouseService {

    private WarehouseRepository warehouseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public WarehouseService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public void addWarehouse(AddWarehouseDto warehouseDto){
        Warehouse warehouse = modelMapper.map(warehouseDto, Warehouse.class);
        warehouse.setId(UUID.randomUUID());

        warehouseRepository.saveAndFlush(warehouse);
    }

    @Override
    public List<ShowWarehouseDto> allWarehouses(){
        return warehouseRepository.findAll().stream().map(warehouse -> modelMapper.map(warehouse, ShowWarehouseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteWarehouse(String name){
        warehouseRepository.deleteByName(name);
    }



    @Autowired
    public void setWarehouseRepository(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }
}
