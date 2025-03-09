package com.rotini.sales.controller;


import com.rotini.sales.domain.Customer;
import com.rotini.sales.domain.Product;
import com.rotini.sales.repository.ProductRepository;
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
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productRepository.save(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@RequestParam Long id) {
        return ResponseEntity.ok(productRepository.findById(id).orElse(null));
    }
    @GetMapping("")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id, @Valid @RequestBody Product product) {
        return null;
    }
}
