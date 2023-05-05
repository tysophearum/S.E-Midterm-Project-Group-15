package com.example.demo.service.serviceImpl;

import com.example.demo.model.Drink_size;
import com.example.demo.repository.DrinkSizeRepository;
import com.example.demo.service.DrinkSizeService;

public class DrinkSizeServiceImpl implements DrinkSizeService {
    private DrinkSizeRepository drinkSizeRepository;

    public DrinkSizeServiceImpl(DrinkSizeRepository drinkSizeRepository) {
        super();
        this.drinkSizeRepository = drinkSizeRepository;
    }


    @Override
    public Boolean isEmpty() {
        Long count = drinkSizeRepository.count();
        if(count>0){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public Drink_size saveDrink_size(Drink_size drink_size) {
        return drinkSizeRepository.save(drink_size);
    }
    
}
