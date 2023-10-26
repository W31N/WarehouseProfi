package com.example.warehouseprofi.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class Users extends Base{

    @OneToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
    private List<TheUserTakesAnItemsFromTheWarehouse> theUserTakesAnItemsFromTheWarehouses;

    @ManyToOne
    @JoinColumn(name = "items_id")
    private Items items;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    private String username;
    private String role;

    protected Users() {};

    public List<TheUserTakesAnItemsFromTheWarehouse> getTheUserTakesAnItemsFromTheWarehouses() {
        return theUserTakesAnItemsFromTheWarehouses;
    }

    public void setTheUserTakesAnItemsFromTheWarehouses(List<TheUserTakesAnItemsFromTheWarehouse> theUserTakesAnItemsFromTheWarehouses) {
        this.theUserTakesAnItemsFromTheWarehouses = theUserTakesAnItemsFromTheWarehouses;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}