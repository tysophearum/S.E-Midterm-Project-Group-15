package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Receipt;
import com.example.demo.service.ReceiptService;

@Controller
public class ReceiptController {
    private ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        super();
        this.receiptService = receiptService;
    }

    @PostMapping("/check/save_receipt")
    public String saveReceipt(@ModelAttribute("receipt") Receipt receipt){
        receiptService.saveReceipt(receipt);
        return "redirect:/checkout/print_receipt";
    }

    @GetMapping("/checkout/print_receipt")
    public String printReceipt(){
        return "PrintReceipt";
    }

}
