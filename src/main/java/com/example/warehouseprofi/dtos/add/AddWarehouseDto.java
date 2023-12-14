package com.example.warehouseprofi.dtos.add;

import com.example.warehouseprofi.utils.UniqueWarehouseName;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AddWarehouseDto {

    @UniqueWarehouseName
    private String name;
    private String address;

    @NotEmpty(message = "Warehouse name must not be null or empty!")
    @Size(min = 2, message = "Warehouse name must be at least 2 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty(message = "Warehouse address must not be null or empty!")
    @Size(min = 2, message = "Warehouse address must be at least 2 characters!")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
