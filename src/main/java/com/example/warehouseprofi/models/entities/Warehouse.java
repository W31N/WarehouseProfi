package com.example.warehouseprofi.models.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "warehouses")
public class Warehouse extends BaseEntity {
    private String name;
    private String address;
    private Set<User> users;
    private Set<Item> items;

    @OneToMany(mappedBy = "warehouse", targetEntity = Item.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @OneToMany(mappedBy = "warehouse", targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}