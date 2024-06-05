package com.pruebatecnica.pruebatecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pruebatecnica.pruebatecnica.model.Customer;
import com.pruebatecnica.pruebatecnica.repository.CustomerRepository;

public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).get();
    }
}
