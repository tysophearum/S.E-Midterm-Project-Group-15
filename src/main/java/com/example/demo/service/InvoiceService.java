package com.example.demo.service;

import com.example.demo.model.Invoice;

public interface InvoiceService {
    Integer getNewInvoiceNumber();
    Invoice saveInvoice( Invoice invoice );
    Invoice getInvoiceById( Integer id);
}
