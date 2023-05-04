package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CafeController {

    @GetMapping("/project/PrintReceipt")
    public ModelAndView PrintReceipt() {
        ModelAndView mv = new ModelAndView("PrintReceipt");
        return mv;
    }

    @GetMapping("/project/AddEditCashier")
    public ModelAndView AddEditCashier() {
        ModelAndView mv = new ModelAndView("AddEditCashier");
        return mv;
    }

    @GetMapping("/project/CategoriesManagement")
    public ModelAndView CategoriesManagement() {
        ModelAndView mv = new ModelAndView("CategoriesManagement");
        return mv;
    }

    @GetMapping("/project/TableManagement")
    public ModelAndView TableManagement() {
        ModelAndView mv = new ModelAndView("TableManagement");
        return mv;
    }

    @GetMapping("/project/ProductManagement")
    public ModelAndView ProductManagement() {
        ModelAndView mv = new ModelAndView("ProductManagement");
        return mv;
    }
}
