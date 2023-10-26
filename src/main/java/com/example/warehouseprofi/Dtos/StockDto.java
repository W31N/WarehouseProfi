package com.example.warehouseprofi.Dtos;

public class StockDto {
    private Long id;
    private String warehouse_name;
    private String warehouse_address;

    protected StockDto() {};

    public StockDto(Long id, String warehouse_name, String warehouse_address) {
        this.id = id;
        this.warehouse_name = warehouse_name;
        this.warehouse_address = warehouse_address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                ", warehouse_name='" + warehouse_name + '\'' +
                ", warehouse_address='" + warehouse_address + '\'' +
                '}';
    }
}