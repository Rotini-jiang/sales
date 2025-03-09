package com.rotini.sales.service;

import com.rotini.sales.domain.Customer;
import com.rotini.sales.domain.Product;
import com.rotini.sales.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product){
        return productRepository.save(product);
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    public boolean deleteById(Long id) {
        return false;
    }
}
