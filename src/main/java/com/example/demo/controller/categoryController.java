package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.model.Product;
import com.example.demo.model.Product_category;
import com.example.demo.service.CategoryService;

@Controller
public class categoryController {
    private CategoryService categoryService;

    public categoryController(CategoryService categoryService) {
        super();
        this.categoryService = categoryService;
    }

    @GetMapping("/product_management/add_new_product")
    public String addNewProductForm(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("drink", new Product());
        return "addNewDrink";
    }

    @GetMapping("/product_management/add_new_category")
    public String createCategory(Model model){
        Product_category newCategory = new Product_category();
        model.addAttribute("category", newCategory);
        return "AddCategories";
    }

    @PostMapping("/product_management/save_new_category")
    public String saveCategory(@RequestParam("code") String code, @RequestParam("name") String name, @RequestParam("type") String type){
        Product_category category = new Product_category();
        category.setName(name);
        category.setCode(code);
        category.setType(type);
        categoryService.saveCategory(category);
        return "redirect:/product_management/drink";
    }

    @PostMapping("/product_management/save_new_category_from_product")
    public String saveCategoryFromProduct(@RequestParam("code") String code, @RequestParam("name") String name, @RequestParam("type") String type){
        Product_category category = new Product_category();
        category.setName(name);
        category.setCode(code);
        category.setType(type);
        categoryService.saveCategory(category);
        return "redirect:/product_management/add_new_product";
    }

}
