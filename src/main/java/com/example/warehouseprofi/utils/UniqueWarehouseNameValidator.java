package com.example.warehouseprofi.utils;

import com.example.warehouseprofi.repositories.WarehouseRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueWarehouseNameValidator implements ConstraintValidator<UniqueWarehouseName, String> {

    private final WarehouseRepository warehouseRepository;

    public UniqueWarehouseNameValidator(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return warehouseRepository.findByName(value).isEmpty();
    }
}
