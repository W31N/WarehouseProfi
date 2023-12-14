package com.example.warehouseprofi.repositories;

import com.example.warehouseprofi.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findByName(com.example.warehouseprofi.models.enums.Role name);


    @Modifying
    @Transactional
    void deleteByName(com.example.warehouseprofi.models.enums.Role name);
}
