package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Drink_size;

public interface DrinkSizeService {
    Boolean isEmpty();
    Drink_size saveDrink_size(Drink_size drink_size);
    List<Drink_size> getAllDrinkSizes();
    Drink_size getSizeById(Integer id);
}
