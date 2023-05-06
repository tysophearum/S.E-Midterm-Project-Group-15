package com.example.demo.info;

import java.util.List;

import com.example.demo.model.Addons;
import com.example.demo.model.Drink;
import com.example.demo.model.Drink_order;
import com.example.demo.model.Drink_size;

public class OrderInfo {
    private List<Addons> addonsList;
    private Drink drink;
    private Drink_size size;
    private Drink_order drink_order;

    public OrderInfo(List<Addons> addonsList, Drink drink, Drink_size size, Drink_order drink_order) {
        this.addonsList = addonsList;
        this.drink = drink;
        this.size = size;
        this.drink_order = drink_order;
    } 

    public OrderInfo(Drink drink, Drink_size size, Drink_order drink_order) {
        this.drink = drink;
        this.size = size;
        this.drink_order = drink_order;
    }    
    

    public OrderInfo(Drink drink, Drink_size size) {
        this.drink = drink;
        this.size = size;
    }

    public List<Addons> getAddonsList() {
        return this.addonsList;
    }

    public void setAddonsList(List<Addons> addonsList) {
        this.addonsList = addonsList;
    }

    public Drink getDrink() {
        return this.drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Drink_size getSize() {
        return this.size;
    }

    public void setSize(Drink_size size) {
        this.size = size;
    }

    public Drink_order getDrink_order() {
        return this.drink_order;
    }

    public void setDrink_order(Drink_order drink_order) {
        this.drink_order = drink_order;
    }


}
