package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Drink;

public interface DrinkService {
    Drink saveDrink(Drink drink, MultipartFile file);
    List<Drink> getAllDrinks();
    Drink getDrinkById(Integer id);
    void deleteDrink(Integer id);
    Drink getFirstDrink();
}
