package com.example.AeroParker.repositories;

import com.example.AeroParker.models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}