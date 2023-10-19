package com.example.warehouseprofi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "theusertakesanitemsfromthewarehouse")
public class TheUserTakesAnItemsFromTheWarehouse extends Base {
    @ManyToMany
    @JoinColumn(name = "user_id")
    private Users users;
    @ManyToMany
    @JoinColumn(name = "item_id")
    private Items items;

    protected TheUserTakesAnItemsFromTheWarehouse() {};

    public TheUserTakesAnItemsFromTheWarehouse(Users users, Items items) {
        this.users = users;
        this.items = items;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}