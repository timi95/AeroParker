package com.example.AeroParker.repositories;

import com.example.AeroParker.models.Customer;
import com.google.common.base.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}