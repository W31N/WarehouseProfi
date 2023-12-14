package com.example.warehouseprofi.web;

import com.example.warehouseprofi.dtos.add.AddWarehouseDto;
import com.example.warehouseprofi.services.impl.WarehouseService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/warehouses")
public class WarehouseController {

    private WarehouseService warehouseService;

    @GetMapping("/add")
    public String addWarehouse(){
        return "warehouse-add";
    }

    @ModelAttribute("warehouseModel")
    public AddWarehouseDto initWarehouse(){
        return new AddWarehouseDto();
    }

    @PostMapping("/add")
    public String addWarehouse(@Valid AddWarehouseDto warehouseModel, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("warehouseModel", warehouseModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.warehouseModel",
                    bindingResult);
            return "redirect:/warehouses/add";
        }
        warehouseService.addWarehouse(warehouseModel);

        return "redirect:/";
    }

    @GetMapping("/all")
    public String showAllWarehouses(Model model){
        model.addAttribute("allWarehouses", warehouseService.allWarehouses());

        return "warehouse-all";
    }

    @GetMapping("/warehouse-delete/{warehouse-name}")
    public String deleteWarehouse(@PathVariable("warehouse-name") String warehouseName){
        warehouseService.deleteWarehouse(warehouseName);

        return "redirect:/warehouses/all";
    }

    @Autowired
    public void setWarehouseService(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }
}
