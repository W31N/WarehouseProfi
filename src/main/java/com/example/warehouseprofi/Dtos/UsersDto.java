package com.example.warehouseprofi.Dtos;

public class UsersDto {
    private Long id;
    private ItemsDto items;
    private StockDto stock;
    private String username;
    private String role;

    protected UsersDto() {}

    public UsersDto(Long id, ItemsDto items, StockDto stock, String username, String role) {
        this.id = id;
        this.items = items;
        this.stock = stock;
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemsDto getItems() {
        return items;
    }

    public void setItems(ItemsDto items) {
        this.items = items;
    }

    public StockDto getStock() {
        return stock;
    }

    public void setStock(StockDto stock) {
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

    @Override
    public String toString() {
        return "UsersDto{" +
                "id=" + id +
                ", items=" + ((items != null) ? items.toString() : "N/A") +
                ", stock=" + ((stock != null) ? stock.toString() : "N/A") +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
