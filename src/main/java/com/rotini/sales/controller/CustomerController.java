package com.rotini.sales.controller;

import com.rotini.sales.domain.Customer;
import com.rotini.sales.domain.CustomerDepositDTO;
import com.rotini.sales.domain.CustomerWithdrawDTO;
import com.rotini.sales.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Customer> getById(@RequestParam Integer id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Integer id, @RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Integer id, @Valid @RequestBody Customer customer) {
        return null;
    }

    @PatchMapping("/{id}/deposit")
    public ResponseEntity<Customer> deposit(@PathVariable Integer id, @Valid @RequestBody CustomerDepositDTO customerDepositDTO) {
        return ResponseEntity.ok(customerService.deposit(id, customerDepositDTO));
    }

    @PatchMapping("/{id}/withdraw")
    public ResponseEntity<Customer> withdraw(@PathVariable Integer id, @Valid @RequestBody CustomerWithdrawDTO customerWithdrawDTO) {
        return ResponseEntity.ok(customerService.withdraw(id, customerWithdrawDTO));
    }

}
