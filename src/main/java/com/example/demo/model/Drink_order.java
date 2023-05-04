package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Drink_order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private Integer drink_id;

    private String addon_ids;

    private Integer size_id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDrink_id() {
        return this.drink_id;
    }

    public void setDrink_id(Integer drink_id) {
        this.drink_id = drink_id;
    }

    public String getAddon_ids() {
        return this.addon_ids;
    }

    public void setAddon_ids(String addon_ids) {
        this.addon_ids = addon_ids;
    }

    public Integer getSize_id() {
        return this.size_id;
    }

    public void setSize_id(Integer size_id) {
        this.size_id = size_id;
    }

}
