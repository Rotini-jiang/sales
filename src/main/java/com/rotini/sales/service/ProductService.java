package com.rotini.sales.service;

import com.rotini.sales.domain.Customer;
import com.rotini.sales.domain.Product;
import com.rotini.sales.domain.ProductAddQuantityDTO;
import com.rotini.sales.exception.BadRequestException;
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

    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new BadRequestException("ID Not Found"));
    }

    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    public boolean deleteById(Long id) {
        return false;
    }

    public Product getByCode(String code) {
        return productRepository.findByCode(code).orElseThrow(() -> new BadRequestException("Product not found"));
    }

    public Product add(Integer id, ProductAddQuantityDTO productAddQuantityDTO) {
        Product product = findById(id);
        product.setQuantity(productAddQuantityDTO.getQuantity().intValue());
        return productRepository.save(product);
    }

    public Product updateQuantity(Integer id, Product product) {
        Product existingProduct = findById(id);
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }

}
