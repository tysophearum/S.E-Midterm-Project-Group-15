package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.ui.Model;

import com.example.demo.info.OrderInfo;
import com.example.demo.model.Drink;
import com.example.demo.model.Drink_category;
import com.example.demo.model.Drink_order;
import com.example.demo.service.AddonsService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.DrinkOrderService;
import com.example.demo.service.DrinkService;
import com.example.demo.service.DrinkSizeService;

@Controller
public class DrinkController {
    private DrinkService drinkService;
    private CategoryService categoryService;
    private AddonsService addonsService;
    private DrinkSizeService drinkSizeService;
    private DrinkOrderService drinkOrderService;

    public DrinkController(DrinkService drinkService, CategoryService categoryService, AddonsService addonsService, DrinkSizeService drinkSizeService, DrinkOrderService drinkOrderService) {
        super();
        this.drinkService = drinkService;
        this.categoryService = categoryService;
        this.addonsService = addonsService;
        this.drinkSizeService = drinkSizeService;
        this.drinkOrderService = drinkOrderService;
    }

    @PostMapping("/new_drink")
    public String saveDrink(@ModelAttribute("drink") Drink drink, @RequestParam("file") MultipartFile file){
        drinkService.saveDrink(drink, file);
        return "redirect:/new_drink";
    }

    @GetMapping("/list_drink")
    public String showDrinks(Model model){
        Drink_order newOrder = new Drink_order();
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("drinks", drinkService.getAllDrinks());
        model.addAttribute("sugars", addonsService.getSugar());
        model.addAttribute("cream", addonsService.getCream());
        model.addAttribute("sizes", drinkSizeService.getAllDrinkSizes());
        model.addAttribute("order", newOrder);
        List<OrderInfo>orderInfos = new ArrayList<OrderInfo>();
        for (Drink_order order : drinkOrderService.getAllOrders()){
            orderInfos.add(new OrderInfo(drinkService.getDrinkById(order.getDrink_id()), drinkSizeService.getSizeById(order.getSize_id()), drinkOrderService.getOrderById(order.getId())));
        }
        model.addAttribute("allOrders", orderInfos);
        return "drinkSelection";
    }

    @GetMapping("/drink_management")
    public String listDrink (Model model) {
        model.addAttribute("drinks", drinkService.getAllDrinks());
        return "drinkManagement";
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
        return "viewDrink";
    }
}
