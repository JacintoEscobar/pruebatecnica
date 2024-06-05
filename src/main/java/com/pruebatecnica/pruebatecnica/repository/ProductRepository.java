package com.pruebatecnica.pruebatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebatecnica.pruebatecnica.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
