package com.example.warehouseprofi.Services.Impl;

import com.example.warehouseprofi.Controllers.Exception.ItemsConflictException;
import com.example.warehouseprofi.Controllers.Exception.ItemsNotFoundException;
import com.example.warehouseprofi.Dtos.ItemsDto;
import com.example.warehouseprofi.Repositories.ItemsRepository;
import com.example.warehouseprofi.Services.ItemsService;
import com.example.warehouseprofi.models.Items;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ItemsServiceImpl(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @Override
    public ItemsDto register(ItemsDto items) {
        Items i = modelMapper.map(items, Items.class);
        if (i.getId() == null || i.getId() == 0 || get(i.getId()).isEmpty()) {
            return modelMapper.map(itemsRepository.save(i), ItemsDto.class);
        } else {
            throw new ItemsConflictException("Предметы с такими идентификаторами уже существуют");
        }
    }

    @Override
    public List<ItemsDto> getAll() {
        return itemsRepository.findAll().stream().map((s) -> modelMapper.map(s, ItemsDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ItemsDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(itemsRepository.findById(id), ItemsDto.class));
    }

    @Override
    public void delete(Long id) {
        if (itemsRepository.findById(id).isPresent()) {
            itemsRepository.deleteById(id);
        } else {
            throw new ItemsNotFoundException(id);
        }
    }

    @Override
    public ItemsDto update(ItemsDto items) {
        if (itemsRepository.findById(items.getId()).isPresent()) {
            return modelMapper.map(itemsRepository.save(modelMapper.map(items, Items.class)), ItemsDto.class);
        } else {
            throw new ItemsNotFoundException(items.getId());
        }
    }

    @Override
    public List<ItemsDto> findItemsByName(String item_name) {
        return itemsRepository.findItemsByName(item_name).stream().map((s) -> modelMapper.map(s, ItemsDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ItemsDto> findItemsByUsersName(String username) {
        return itemsRepository.findItemsByUsersName(username).stream().map((s) -> modelMapper.map(s, ItemsDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ItemsDto> findItemsByStockAddress(String warehouse_address) {
        return itemsRepository.findItemsByStockAddress(warehouse_address).stream().map((s) -> modelMapper.map(s, ItemsDto.class)).collect(Collectors.toList());
    }
}