package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Invoice;
import com.example.demo.service.CurrentProductOrderService;
import com.example.demo.service.InvoiceService;
import com.example.demo.service.TableService;

@Controller
public class TableController {
    private TableService tableService;
    private CurrentProductOrderService currentDrinkOrderService;
    private InvoiceService invoiceService;

    public TableController(TableService tableService, CurrentProductOrderService currentDrinkOrderService, InvoiceService invoiceService) {
        super();
        this.tableService = tableService;
        this.currentDrinkOrderService = currentDrinkOrderService;
        this.invoiceService = invoiceService;
    }

    @GetMapping("/table_management")
    public String manageTable(Model model){
        model.addAttribute("tableAmount", tableService.getTableAmount());
        return "tableManagement";
    }
    
    @GetMapping("/table_selection")
    public String selectTable(Model model){
        Invoice newInvoice = new Invoice();
        newInvoice.setProduct_order_ids(currentDrinkOrderService.getAllOrderIds());
        newInvoice.setNumber(invoiceService.getNewInvoiceNumber());
        newInvoice.setPrice(currentDrinkOrderService.getTotalPrice());
        model.addAttribute("invoice", newInvoice);
        model.addAttribute("tables", tableService.getAllTable());
        return "tableSelection";
    }

    @PostMapping("/table_management/set_number_of_table")
    public String setTableAmount(@RequestParam("tableAmount") Integer tableAmount){
        tableService.setNewTableAmount(tableAmount);
        return "redirect:/product_management/drink";
    }

    @PostMapping("/tableAvailebility/edit")
    public String setTableAvaileble(@RequestParam("tableID") Integer tableID){
        tableService.setTableAvaileble(tableID);
        return "redirect:/table_selection";
    }
}
