package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Drink_order;

public interface DrinkOrderService {
    List<Drink_order> getAllOrders();
    Drink_order saveOrder(Drink_order drink_order);
    Drink_order getOrderById(Integer id);
}
