package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Drink_size;

public interface DrinkSizeRepository extends JpaRepository<Drink_size, Integer> {
    
}
