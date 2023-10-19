package com.example.warehouseprofi.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "item")
public class Items extends Base {
    @OneToMany(mappedBy = "items", cascade = CascadeType.REMOVE)
    private List<TheUserTakesAnItemsFromTheWarehouse> itemsServices;

    @OneToMany(mappedBy = "items", cascade = CascadeType.REMOVE)
    private List<Stock> stocks;

    private String item_name;
    private Date date_taken;
    private Date return_date;

    protected Items() {};

    public List<TheUserTakesAnItemsFromTheWarehouse> getItemsServices() {
        return itemsServices;
    }

    public void setItemsServices(List<TheUserTakesAnItemsFromTheWarehouse> itemsServices) {
        this.itemsServices = itemsServices;
    }

    public List<Stock> getStock() {
        return stocks;
    }

    public void setStocks(List<Stock> itemsStocks) {
        this.stocks = itemsStocks;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Date getDate_taken() {
        return date_taken;
    }

    public void setDate_taken(Date date_taken) {
        this.date_taken = date_taken;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
}