package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Drink_order;
import com.example.demo.repository.DrinkOrderRepository;
import com.example.demo.service.DrinkOrderService;

@Service
public class DrinkOrderServiceImpl implements DrinkOrderService {
    private DrinkOrderRepository drinkOrderRepository;

    public DrinkOrderServiceImpl(DrinkOrderRepository drinkOrderRepository) {
        super();
        this.drinkOrderRepository = drinkOrderRepository;
    }


    @Override
    public List<Drink_order> getAllOrders() {
        return drinkOrderRepository.findAll();
    }

    @Override
    public Drink_order saveOrder(Drink_order drink_order) {
        return drinkOrderRepository.save(drink_order) ;
    }


    @Override
    public Drink_order getOrderById(Integer id) {
        return drinkOrderRepository.findById(id).get();
    }
    
}
