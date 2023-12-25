package com.example.warehouseprofi.services.impl;

import com.example.warehouseprofi.dtos.add.AddItemDto;
import com.example.warehouseprofi.dtos.show.ShowItemDto;
import com.example.warehouseprofi.models.entities.Item;
import com.example.warehouseprofi.repositories.ItemRepository;
import com.example.warehouseprofi.repositories.UserRepository;
import com.example.warehouseprofi.repositories.WarehouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ItemService implements com.example.warehouseprofi.services.ItemService {

    ItemRepository itemRepository;
    WarehouseRepository warehouseRepository;
    UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ItemService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        modelMapper.createTypeMap(Item.class, ShowItemDto.class)
                .addMapping(src -> src.getWarehouse().getName(), ShowItemDto::setWarehouse)
                .addMapping(src -> src.getUser().getUsername(), ShowItemDto::setUser);
    }


    @Override
    public void takeItem(String uuid, Principal principal){
        Item item = itemRepository.findById(UUID.fromString(uuid)).orElse(null);
        item.setTaken(true);
        item.setDateTaken(LocalDate.now());
        item.setUser(userRepository.findByUsername(principal.getName()).orElse(null));

        itemRepository.saveAndFlush(item);
    }



    @Override
    public void addItem(AddItemDto itemDto){
        Item item = modelMapper.map(itemDto, Item.class);
        item.setId(UUID.randomUUID());
        item.setTaken(false);
        item.setWarehouse(warehouseRepository.findByName(itemDto.getWarehouseName()).orElse(null));

        itemRepository.saveAndFlush(item);
    }

    @Override
    public List<ShowItemDto> allItems(){
        return itemRepository.findAll().stream().map(item -> modelMapper.map(item, ShowItemDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteItem(String uuid){
        itemRepository.deleteById(UUID.fromString(uuid));
    }

    @Override
    public List<ShowItemDto> allItemsOfCurrentUser(Principal principal){
        return itemRepository.findAllByUserUsername(principal.getName()).stream().map(item -> modelMapper.map(item, ShowItemDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void returnItem(String uuid){
        Item item = itemRepository.findById(UUID.fromString(uuid)).orElse(null);
        item.setDateReturn(LocalDate.now());
        item.setTaken(false);

        itemRepository.saveAndFlush(item);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    @Autowired
    public void setWarehouseRepository(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }
}
