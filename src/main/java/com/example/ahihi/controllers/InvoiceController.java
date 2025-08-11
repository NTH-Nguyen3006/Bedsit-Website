package com.example.ahihi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceController {

    @GetMapping("/hoa-don")
    public String getMethodName() {
        return "pages/invoice";
    }
}
