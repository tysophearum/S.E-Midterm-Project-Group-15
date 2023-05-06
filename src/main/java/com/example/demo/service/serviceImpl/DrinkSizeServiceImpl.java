package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Drink_size;
import com.example.demo.repository.DrinkSizeRepository;
import com.example.demo.service.DrinkSizeService;

@Service
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

    @Override
    public List<Drink_size> getAllDrinkSizes() {
        return drinkSizeRepository.findAll();
    }

    @Override
    public Drink_size getSizeById(Integer id) {
        return drinkSizeRepository.findById(id).get();
    }
    
}
