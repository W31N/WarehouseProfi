package com.example.warehouseprofi.Dtos;

public class StockDto {
    private Long id;
    private ItemsDto items;
    private String warehouse_name;
    private String warehouse_address;

    protected StockDto() {}

    public StockDto(Long id, ItemsDto items, String warehouse_name, String warehouse_address) {
        this.id = id;
        this.items = items;
        this.warehouse_name = warehouse_name;
        this.warehouse_address = warehouse_address;
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

    @Override
    public String toString() {
        return "StockDto{" +
                "id=" + id +
                ", items=" + ((items != null) ? items.toString() : "N/A") +
                ", warehouse_name='" + warehouse_name + '\'' +
                ", warehouse_address='" + warehouse_address + '\'' +
                '}';
    }
}
