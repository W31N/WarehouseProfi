package com.example.warehouseprofi.models;

import jakarta.persistence.*;
import org.modelmapper.ModelMapper;

import java.util.List;

@Entity
@Table(name = "stocks")
public class Stock extends Base{
    @OneToMany(mappedBy = "stock", cascade = CascadeType.REMOVE)
    private List<Items> items;
    private String warehouse_name;
    private String warehouse_address;

    protected Stock() {};

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public String getWarehouse_address() {
        return warehouse_address;
    }

    public void setWarehouse_address(String warehouse_address) {
        this.warehouse_address = warehouse_address;
    }
}