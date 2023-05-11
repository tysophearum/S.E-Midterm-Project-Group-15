package com.example.demo.info;

import java.util.List;

import com.example.demo.model.Addons;
import com.example.demo.model.Current_product_order;
import com.example.demo.model.Product;
import com.example.demo.model.Product_size;

public class OrderInfo {
    private List<Addons> addonsList;
    private Product drink;
    private Product_size size;
    private Current_product_order drink_order;
    private Float orderPrice;

    public OrderInfo(List<Addons> addonsList, Product drink, Product_size size, Current_product_order drink_order) {
        this.addonsList = addonsList;
        this.drink = drink;
        this.size = size;
        this.drink_order = drink_order;
    } 

    public OrderInfo(Product drink, Product_size size, Current_product_order drink_order) {
        this.drink = drink;
        this.size = size;
        this.drink_order = drink_order;
    }    
    

    public OrderInfo(Product drink, Product_size size) {
        this.drink = drink;
        this.size = size;
    }

    public List<Addons> getAddonsList() {
        return this.addonsList;
    }

    public void setAddonsList(List<Addons> addonsList) {
        this.addonsList = addonsList;
    }

    public Product getDrink() {
        return this.drink;
    }

    public void setDrink(Product drink) {
        this.drink = drink;
    }

    public Product_size getSize() {
        return this.size;
    }

    public void setSize(Product_size size) {
        this.size = size;
    }

    public Current_product_order getDrink_order() {
        return this.drink_order;
    }

    public void setDrink_order(Current_product_order drink_order) {
        this.drink_order = drink_order;
    }

    public Float getOrderPrice() {
        orderPrice = drink.getPrice() + size.getPrice();
        return orderPrice;
    }
}
