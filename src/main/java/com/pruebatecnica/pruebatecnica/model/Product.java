package com.pruebatecnica.pruebatecnica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "product")
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name cannot be empty")
    @Size(max = 255, message = "name should be 255 characters long")
    private String name;
    
    @Size(max = 255, message = "name should be 500 characters long")
    private String description;
    
    @NotNull(message = "price cannot be null")
    @Positive(message = "price should be greater than zero")
    private Double price;
    
    @NotBlank(message = "sku cannot be null")
    @Column(unique = true)
    private String sku;
}
