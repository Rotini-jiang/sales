package com.rotini.sales.controller;

import com.rotini.sales.domain.Customer;
import com.rotini.sales.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("")
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.create(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@RequestParam Long id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }
}
