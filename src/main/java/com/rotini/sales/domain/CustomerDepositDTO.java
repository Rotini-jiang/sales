package com.rotini.sales.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CustomerDepositDTO {
    @NotNull
    String code;

    @NotNull
    @Positive
    Double amount;
}
