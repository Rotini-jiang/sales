package com.rotini.sales.domain;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CustomerWithdrawDTO {
    @NotNull
    String code;

    @NotNull
    @Positive
    Double amount;
}
