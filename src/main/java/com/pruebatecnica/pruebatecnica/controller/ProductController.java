package com.pruebatecnica.pruebatecnica.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.pruebatecnica.model.Product;
import com.pruebatecnica.pruebatecnica.service.ProductService;
import com.pruebatecnica.pruebatecnica.util.RequestValidation;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {
    @Autowired
    private RequestValidation requestValidation;

    @Autowired
    private ProductService productService;

    // GET /products: Obtener todos los productos.
    @GetMapping
    public ResponseEntity<?> getProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // GET /products/{id}: Obtener un producto por su ID.
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        Product product = null;
        
        try {
            product = productService.getProduct(id);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>("product not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product, HttpStatus.FOUND);
    }

    // POST /products: Crear un nuevo producto.
    @PostMapping
    public ResponseEntity<?> postProduct(@RequestBody @Valid Product product, BindingResult validation) {
        return new ResponseEntity<>("post products endpoint", HttpStatus.CREATED);
    }
    
    // PUT /products/{id}: Actualizar un producto existente por su ID.
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> putProduct(@PathVariable Long id, @RequestBody Product product) {
        return new ResponseEntity<>("put products endpoint", HttpStatus.OK);
    }
    
    // DELETE /products/{id}: Eliminar un producto por su ID
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return new ResponseEntity<>("delete products endpoint", HttpStatus.OK);
    }
}
