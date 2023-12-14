package com.example.warehouseprofi.dtos.add;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AddItemDto {

    private String name;
    private String warehouseName;

    @NotEmpty(message = "Item name must not be null or empty!")
    @Size(min = 1, message = "Item name must be at least 1 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty(message = "Please choose a warehouse!")
    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
}
