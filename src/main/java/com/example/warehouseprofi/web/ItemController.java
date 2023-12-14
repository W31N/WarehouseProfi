package com.example.warehouseprofi.web;

import com.example.warehouseprofi.dtos.add.AddItemDto;
import com.example.warehouseprofi.services.impl.ItemService;
import com.example.warehouseprofi.services.impl.WarehouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;
    private WarehouseService warehouseService;

    @GetMapping("/add")
    public String addItem(Model model){
        model.addAttribute("availableWarehouses", warehouseService.allWarehouses());


        return "item-add";
    }

    @ModelAttribute("itemModel")
    public AddItemDto initModel(){
        return new AddItemDto();
    }

    @PostMapping("/add")
    public String addItem(@Valid AddItemDto itemModel, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("itemModel", itemModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemModel",
                    bindingResult);
            return "redirect:/items/add";
        }
        itemService.addItem(itemModel);

        return "redirect:/";
    }

    @GetMapping("/all")
    public String showAllItems(Model model){
        model.addAttribute("allItems", itemService.allItems());

        return "item-all";
    }

    @GetMapping("/item-delete/{id}")
    public String deleteItem(@PathVariable("id") String uuid){
        itemService.deleteItem(uuid);

        return "redirect:/items/all";
    }

    @Autowired
    public void setWarehouseService(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }
}
