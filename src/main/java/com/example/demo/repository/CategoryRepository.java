package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Drink_category;

public interface CategoryRepository extends JpaRepository <Drink_category, Integer> {
    
}
