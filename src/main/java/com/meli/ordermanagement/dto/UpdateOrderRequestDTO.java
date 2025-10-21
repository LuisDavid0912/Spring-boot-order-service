package com.meli.ordermanagement.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

/**
 * DTO (Data Transfer Object) used as a "form" to receive data
 * when updating an existing order.
 */
@Data
public class UpdateOrderRequestDTO {

    @NotBlank(message = "Customer name cannot be empty.")
    private String customerName;

    @NotBlank(message = "Status cannot be empty.")
    private String status;

    @NotNull(message = "Total amount cannot be null.")
    @Positive(message = "Total amount must be a positive number.")
    private BigDecimal totalAmount;
}

