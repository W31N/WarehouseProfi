package com.example.warehouseprofi.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "items")
public class Items extends Base {
    @OneToMany(mappedBy = "items", cascade = CascadeType.REMOVE)
    private List<TheUserTakesAnItemsFromTheWarehouse> itemsService;

    @OneToMany(mappedBy = "items", cascade = CascadeType.REMOVE)
    private List<Users> users;

    @OneToMany(mappedBy = "items", cascade = CascadeType.REMOVE)
    private List<Stock> stock;

    private String item_name;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date date_taken;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date return_date;

    protected Items() {};

    public List<TheUserTakesAnItemsFromTheWarehouse> getItemsService() {
        return itemsService;
    }

    public void setItemsService(List<TheUserTakesAnItemsFromTheWarehouse> itemsServices) {
        this.itemsService = itemsServices;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
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