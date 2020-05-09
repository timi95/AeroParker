package com.example.AeroParker.repositories;

import com.example.AeroParker.models.CustomerSite;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSiteRepository extends JpaRepository<CustomerSite, Long> {
    
}