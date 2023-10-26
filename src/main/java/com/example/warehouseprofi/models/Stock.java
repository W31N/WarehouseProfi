package com.example.warehouseprofi.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "stock")
public class Stock extends Base{

    @OneToMany(mappedBy = "stock", cascade = CascadeType.REMOVE)
    private List<Users> users;
    @ManyToOne
    @JoinColumn(name = "items_id")
    private Items items;
    private String warehouse_name;
    private String warehouse_address;

    protected Stock() {};

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
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