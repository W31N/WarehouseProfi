package com.example.warehouseprofi.Init;

import com.example.warehouseprofi.Dtos.*;
import com.example.warehouseprofi.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private StockService stockService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private TheUserTakesAnItemsFromTheWarehouseService theUserTakesAnItemsFromTheWarehouseService;

    @Override
    public void run(String... args) {
        seedData();
    }

    private void printItemsByName(String item_name) {
        itemsService
                .findItemsByName(item_name)
                .forEach(System.out::println);
    }

    private void printItemsByUsersName(String username) {
        itemsService
                .findItemsByUsersName(username)
                .forEach(System.out::println);
    }

    private void printItemsByStockAddress(String warehouse_address) {
        itemsService
                .findItemsByStockAddress(warehouse_address)
                .forEach(System.out::println);
    }



    private void seedData() {
        ItemsDto item1 = new ItemsDto(null, "Computer", "10.10.2023", "15.10.2023");
        ItemsDto item2 = new ItemsDto(null, "Power tools", "05.08.2023", "12.08.2023");
        ItemsDto item3 = new ItemsDto(null, "Medical device", "20.09.2023", "25.09.2023");
        ItemsDto item4 = new ItemsDto(null, "Automotive part", "03.11.2023", "10.11.2023");

        StockDto stock1 = new StockDto(null, "TechnoProduct", "st. Tekhnicheskaya, 123, Gorodovsk");
        StockDto stock2 = new StockDto(null, "Household World", "Zhivopisny Ave., 456, Komfortovo");
        StockDto stock3 = new StockDto(null, "MedTechSnab", "st. Health, 789, Medgrad");
        StockDto stock4 = new StockDto(null, "Avtoshina-Service", "st. Transportnaya, 234, Avtomobilevo");

        item1 = itemsService.register(item1);
        item2 = itemsService.register(item2);
        item3 = itemsService.register(item3);
        item4 = itemsService.register(item4);
        stock1 = stockService.register(stock1);
        stock2 = stockService.register(stock2);
        stock3 = stockService.register(stock3);
        stock4 = stockService.register(stock4);

        UsersDto user1 = new UsersDto(null, null, stock1, "Anna", "Admin");
        UsersDto user2 = new UsersDto(null, item1, stock2, "Maksim", "User");
        UsersDto user3 = new UsersDto(null, null, stock3, "Evgenia", "Admin");
        UsersDto user4 = new UsersDto(null, item2, stock4, "Alexander", "User");

        user1 = usersService.register(user1);
        user2 = usersService.register(user2);
        user3 = usersService.register(user3);
        user4 = usersService.register(user4);

        TheUserTakesAnItemsFromTheWarehouseDto tu1 = new TheUserTakesAnItemsFromTheWarehouseDto(null, user1, null);
        TheUserTakesAnItemsFromTheWarehouseDto tu2 = new TheUserTakesAnItemsFromTheWarehouseDto(null, user2, item1);
        TheUserTakesAnItemsFromTheWarehouseDto tu3 = new TheUserTakesAnItemsFromTheWarehouseDto(null, user3, null);
        TheUserTakesAnItemsFromTheWarehouseDto tu4 = new TheUserTakesAnItemsFromTheWarehouseDto(null, user4, item2);

        tu1 = theUserTakesAnItemsFromTheWarehouseService.register(tu1);
        tu2 = theUserTakesAnItemsFromTheWarehouseService.register(tu2);
        tu3 = theUserTakesAnItemsFromTheWarehouseService.register(tu3);
        tu4 = theUserTakesAnItemsFromTheWarehouseService.register(tu4);

        printItemsByName("Computer");
        printItemsByUsersName("Maksim");
        printItemsByStockAddress("st. Health, 789, Medgrad");
    }
}