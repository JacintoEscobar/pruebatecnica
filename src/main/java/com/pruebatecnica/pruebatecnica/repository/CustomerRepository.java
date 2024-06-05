package com.pruebatecnica.pruebatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebatecnica.pruebatecnica.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
