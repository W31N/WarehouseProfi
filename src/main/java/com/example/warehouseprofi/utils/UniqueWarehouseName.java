package com.example.warehouseprofi.utils;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueWarehouseNameValidator.class)
public @interface UniqueWarehouseName {
    String message() default "Warehouse already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
