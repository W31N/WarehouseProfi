package com.example.warehouseprofi.Controllers;

import com.example.warehouseprofi.Controllers.Exception.ItemsNotFoundException;
import com.example.warehouseprofi.Dtos.ItemsDto;
import com.example.warehouseprofi.Services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsControllers {
    @Autowired
    private ItemsService itemsService;

    @GetMapping()
    Iterable<ItemsDto> all() {
        return itemsService.getAll();
    }

    @GetMapping("/{id}")
    ItemsDto get(@PathVariable Long id) {
        return itemsService.get(id).orElseThrow(() -> new ItemsNotFoundException(id));
    }

    @PostMapping
    ItemsDto createItems(@RequestBody ItemsDto items) {
        return itemsService.register(items);
    }

    @DeleteMapping("/{id}")
    void deleteItems(@PathVariable Long id) {
        itemsService.delete(id);
    }

    @PutMapping()
    ItemsDto update(@RequestBody ItemsDto items) {
        return itemsService.update(items);
    }

    @GetMapping("/byUsersName")
    public ResponseEntity<List<ItemsDto>> getItemsByUsersName(@RequestParam String username) {
        List<ItemsDto> items = itemsService.findItemsByUsersName(username);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/byName")
    public ResponseEntity<List<ItemsDto>> getItemsByName(@RequestParam String items_name) {
        List<ItemsDto> items = itemsService.findItemsByName(items_name);
        return ResponseEntity.ok(items);
    }
}