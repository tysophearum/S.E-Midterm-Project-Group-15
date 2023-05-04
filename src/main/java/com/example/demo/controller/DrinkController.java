package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.ui.Model;

import com.example.demo.model.Drink;
import com.example.demo.model.Drink_category;
import com.example.demo.service.CategoryService;
import com.example.demo.service.DrinkService;

@Controller
public class DrinkController {
    private DrinkService drinkService;
    private CategoryService categoryService;

    public DrinkController(DrinkService drinkService, CategoryService categoryService) {
        super();
        this.drinkService = drinkService;
        this.categoryService = categoryService;
    }

    @PostMapping("/new_drink")
    public String saveCategory(@ModelAttribute("drink") Drink drink, @RequestParam("file") MultipartFile file){
        drinkService.saveDrink(drink, file);
        return "redirect:/new_drink";
    }

    @GetMapping("/list_drink")
    public String showDrinks(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("drinks", drinkService.getAllDrinks());
        return "drinkSelection";
    }

    @GetMapping("/drink_management")
    public String listDrink (Model model) {
        // model.addAttribute("drinks", drinkService.getAllDrinks());
        return "redirect:/drink_management/" + drinkService.getFirstDrink().getId();
    }

    @GetMapping("/drink_management/edit/{id}")
    public String editDrink(@PathVariable Integer id, Model model){
        Drink updateDrink = drinkService.getDrinkById(id);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("drink", updateDrink);
        return "editDrink";
    }

    @PostMapping("/drink_management/{id}")
    public String updateDrink (@PathVariable Integer id, @ModelAttribute("drink") Drink updatedDrink, Model model, @RequestParam("file") MultipartFile file){
        Drink drink = drinkService.getDrinkById(id);
        drink.setId(id);
        drink.setCode(updatedDrink.getCode());
        drink.setName(updatedDrink.getName());
        drink.setCategory_id(updatedDrink.getCategory_id());
        drink.setPrice(updatedDrink.getPrice());
        drink.setNote(updatedDrink.getNote());
        drinkService.saveDrink(drink, file);
        return "redirect:/drink_management";
    }

    @GetMapping("/drink_management/delete/{id}")
    public String deleteDrink (@PathVariable Integer id) {
        drinkService.deleteDrink(id);
        return "redirect:/drink_management";
    }

    @GetMapping("/drink_management/{id}")
    public String showDrink(@PathVariable Integer id, Model model){
        Drink selectDrink = drinkService.getDrinkById(id);
        Drink_category category = categoryService.getCateforyById(selectDrink.getCategory_id());
        model.addAttribute("drinks", drinkService.getAllDrinks());
        model.addAttribute("selectedCategory", category);
        model.addAttribute("selectedDrink", selectDrink);
        return "drinkManagement";
    }
}
