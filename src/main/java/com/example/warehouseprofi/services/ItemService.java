package com.example.warehouseprofi.services;

import com.example.warehouseprofi.dtos.add.AddItemDto;
import com.example.warehouseprofi.dtos.show.ShowItemDto;

import java.security.Principal;
import java.util.List;

public interface ItemService {
    void addItem(AddItemDto itemDto);
    List<ShowItemDto> allItems();
    void deleteItem(String uuid);
    void takeItem(String uuid, Principal principal);
    List<ShowItemDto> allItemsOfCurrentUser(Principal principal);
    void returnItem(String uuid);
}