package com.rotini.sales.controller;


import com.rotini.sales.domain.Customer;
import com.rotini.sales.domain.Product;
import com.rotini.sales.domain.ProductAddQuantityDTO;
import com.rotini.sales.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.create(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }
    @GetMapping("")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Integer id, @Valid @RequestBody Product product) {
        return null;
    }
    
    @GetMapping("/{code}/code")
    public ResponseEntity<Product> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(productService.getByCode(code));
    }

    @PatchMapping("/{id}/quantity")
    public ResponseEntity<Product> updateQuantity(@PathVariable Integer id, @RequestBody ProductAddQuantityDTO quantityDTO) {
        return ResponseEntity.ok(productService.add(id, quantityDTO));
    }

}
