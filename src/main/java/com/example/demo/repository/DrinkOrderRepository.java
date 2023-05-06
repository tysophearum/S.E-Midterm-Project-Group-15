package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Drink_order;

public interface DrinkOrderRepository extends JpaRepository<Drink_order, Integer> {
    
}
