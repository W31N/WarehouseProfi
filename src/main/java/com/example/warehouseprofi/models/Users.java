package com.example.warehouseprofi.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class Users extends Base{

    @ManyToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
    private List<TheUserTakesAnItemsFromTheWarehouse> theUserTakesAnItemsFromTheWarehouses;

    private String username;
    private String role;

    protected Users() {};

    public List<TheUserTakesAnItemsFromTheWarehouse> getTheUserTakesAnItemsFromTheWarehouses() {
        return theUserTakesAnItemsFromTheWarehouses;
    }

    public void setTheUserTakesAnItemsFromTheWarehouses(List<TheUserTakesAnItemsFromTheWarehouse> theUserTakesAnItemsFromTheWarehouses) {
        this.theUserTakesAnItemsFromTheWarehouses = theUserTakesAnItemsFromTheWarehouses;
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