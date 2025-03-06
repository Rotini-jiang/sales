package com.rotini.sales.domain;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String code;

    private Double balance;
}
