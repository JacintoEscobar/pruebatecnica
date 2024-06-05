package com.pruebatecnica.pruebatecnica.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.pruebatecnica.model.Customer;
import com.pruebatecnica.pruebatecnica.model.Product;
import com.pruebatecnica.pruebatecnica.service.CustomerService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/customers")
public class CustomerController {
    private CustomerService customerService;

    // GET /customers: Obtener todos los clientes.
    @GetMapping
    public ResponseEntity<?> getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    
    // GET /customers/{id}: Obtener un cliente por su ID.
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCustomers(@PathVariable Long id) {
        Customer customer = null;
        
        try {
            customer = customerService.getCustomer(id);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>("customer not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.FOUND);
    }
    
    // POST /customers: Crear un nuevo cliente.
    @PostMapping
    public ResponseEntity<?> postCustomers(@RequestBody Customer customer) {
        return new ResponseEntity<>("post customers endpoint", HttpStatus.OK);
    }

    // PUT /customers/{id}: Actualizar un cliente existente por su ID.
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> putCustomers(@PathVariable Long id, @RequestBody Customer customer) {
        return new ResponseEntity<>("put customers endpoint", HttpStatus.OK);
    }
    
    // DELETE /customers/{id}: Eliminar un cliente por su ID.
    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteCustomers(@PathVariable Long id) {
        return new ResponseEntity<>("delete customers endpoint", HttpStatus.OK);
    }
}
