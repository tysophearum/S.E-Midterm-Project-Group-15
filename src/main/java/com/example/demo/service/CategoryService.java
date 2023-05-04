package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Drink_category;

public interface CategoryService {
    Drink_category saveCategory(Drink_category drink_category);
    List<Drink_category> getAllCategories();
    Drink_category getCateforyById(Integer id);
}
