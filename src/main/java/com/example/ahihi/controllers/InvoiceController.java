package com.example.ahihi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ahihi.entities.Invoice;
import com.example.ahihi.sevices.InvoiceService;

import jakarta.websocket.server.PathParam;

@Controller
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/hoa-don")
    public String page(Model model, @PathParam("code") String code) {
        Invoice invoice = null;
        if (code != null)
            invoice = this.invoiceService.getInvoiceByCode(code);
        model.addAttribute("activePage", "hoa-don");
        model.addAttribute("invoice", invoice);

        return "pages/invoice";
    }
}
