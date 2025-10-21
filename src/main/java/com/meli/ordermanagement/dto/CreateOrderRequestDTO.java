package com.meli.ordermanagement.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CreateOrderRequestDTO {

    @NotBlank(message = "Customer name cannot be empty.")
    private String customerName;

    @Positive(message = "Total amount must be a positive number.")
    private BigDecimal totalAmount;

    // Getters and Setters are needed for validation and serialization
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}