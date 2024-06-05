package com.pruebatecnica.pruebatecnica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "username cannot be null")
    @Size(min = 3, max = 50, message = "name should be between 3 and 50 characters long")
    @Column(unique = true)
    private String username;
    
    @NotBlank(message = "password cannot be null")
    @Size(min = 8, message = "name should be 8 characters long as minimum")
    private String password;
    
    @NotBlank(message = "email cannot be null")
    private String email;
    
    private String phoneNumber;
}
