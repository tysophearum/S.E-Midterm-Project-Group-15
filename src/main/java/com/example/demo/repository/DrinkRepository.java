package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Drink;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {
    
}
