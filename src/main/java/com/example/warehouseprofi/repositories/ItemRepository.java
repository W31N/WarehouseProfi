package com.example.warehouseprofi.repositories;

import com.example.warehouseprofi.models.entities.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    List<Item> findAllByUserUsername(String usrname);

}
