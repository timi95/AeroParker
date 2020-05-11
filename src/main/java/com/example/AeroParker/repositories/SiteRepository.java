package com.example.AeroParker.repositories;

import java.util.Optional;

import com.example.AeroParker.models.Site;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository<Site, Long> {
    Optional<Site> findByName(String name);
    
}