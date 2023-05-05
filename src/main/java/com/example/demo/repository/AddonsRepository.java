package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Addons;

public interface AddonsRepository extends JpaRepository<Addons, Integer> {
    
}
