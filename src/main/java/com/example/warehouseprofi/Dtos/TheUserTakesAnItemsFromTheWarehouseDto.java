package com.example.warehouseprofi.Dtos;

public class TheUserTakesAnItemsFromTheWarehouseDto {
    private Long id;
    private UsersDto users;
    private ItemsDto items;

    public TheUserTakesAnItemsFromTheWarehouseDto(Long id, UsersDto users, ItemsDto items) {
        this.id = id;
        this.users = users;
        this.items = items;
    }

    public TheUserTakesAnItemsFromTheWarehouseDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsersDto getUsers() {
        return users;
    }

    public void setUsers(UsersDto users) {
        this.users = users;
    }

    public ItemsDto getItems() {
        return items;
    }

    public void setItems(ItemsDto items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "TheUserTakesAnItemsFromTheWarehouseDto{" +
                "id=" + id +
                ", users=" + ((users != null) ? users.toString() : "N/A") +
                ", items=" + ((items != null) ? items.toString() : "N/A") +
                '}';
    }
}
