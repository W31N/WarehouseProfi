package com.example.warehouseprofi.Repositories;

import com.example.warehouseprofi.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}