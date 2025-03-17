package com.rotini.sales.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class ProductAddQuantityDTO {
    @NotNull     Long id;
    @NotNull    @Positive    Long quantity;

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}