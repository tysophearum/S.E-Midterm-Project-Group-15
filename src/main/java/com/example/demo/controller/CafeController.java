package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CafeController {
    @GetMapping("/cafe/cashier")
    public ModelAndView cashier() {
        // return new ModelAndView("task2");
        ModelAndView mnv = new ModelAndView("cashier");
        // mnv.addObject("username", "khema");
        return mnv;
    }
}
