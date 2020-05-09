package com.example.AeroParker.repositories;

import com.example.AeroParker.models.Site;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository<Site, Long> {
    
}