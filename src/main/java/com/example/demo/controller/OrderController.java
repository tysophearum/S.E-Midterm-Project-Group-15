package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Current_product_order;
import com.example.demo.model.Product_order;
import com.example.demo.service.CurrentProductOrderService;
import com.example.demo.service.ProductOrderService;

@Controller
public class OrderController {
    private ProductOrderService drinkOrderService;
    private CurrentProductOrderService currentDrinkOrderService;

    public OrderController(ProductOrderService drinkOrderService, CurrentProductOrderService currentDrinkOrderService) {
        super();
        this.drinkOrderService = drinkOrderService;
        this.currentDrinkOrderService = currentDrinkOrderService;
    }

    @PostMapping("/save_order")
    public String saveOrder(@ModelAttribute("order") Current_product_order drink_order){
        currentDrinkOrderService.saveOrder(drink_order);
        return "redirect:/list_drink";
    }

    @GetMapping("/list_drink/delete/{id}")
    public String deleteOrder(@PathVariable Integer id){
        currentDrinkOrderService.deleteOrder(id);
        return "redirect:/list_drink";
    }
}
