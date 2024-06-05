package com.pruebatecnica.pruebatecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.pruebatecnica.model.Product;
import com.pruebatecnica.pruebatecnica.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }
}
