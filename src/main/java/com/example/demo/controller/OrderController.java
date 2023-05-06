package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Drink_order;
import com.example.demo.service.DrinkOrderService;

@Controller
public class OrderController {
    private DrinkOrderService drinkOrderService;

    public OrderController(DrinkOrderService drinkOrderService) {
        super();
        this.drinkOrderService = drinkOrderService;
    }

    @PostMapping("/save_order")
    public String saveOrder(@ModelAttribute("order") Drink_order drink_order){
        drinkOrderService.saveOrder(drink_order);
        return "redirect:/list_drink";
    }
}
