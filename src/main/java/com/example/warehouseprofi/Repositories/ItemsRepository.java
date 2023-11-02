package com.example.warehouseprofi.Repositories;

import com.example.warehouseprofi.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items, Long> {
    @Query("SELECT i FROM Items i WHERE i.item_name = :item_name")
    List<Items> findItemsByName(@Param("item_name") String item_name);

    @Query("SELECT i FROM Items i JOIN i.users u WHERE u.username = :username")
    List<Items> findItemsByUsersName(@Param("username") String username);

    @Query("SELECT i FROM Items i JOIN i.stock s WHERE s.warehouse_address = :warehouse_address")
    List<Items> findItemsByStockAddress(@Param("warehouse_address") String warehouse_address);
}