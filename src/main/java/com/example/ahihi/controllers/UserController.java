package com.example.ahihi.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ahihi.entities.Invoice;
import com.example.ahihi.sevices.RoomService;
import com.example.ahihi.sevices.UserService;

@Controller
public class UserController {

    @Autowired
    RoomService roomService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String homePage(Model model) {
        model.addAttribute("activePage", "home");
        model.addAttribute("roomRecentUpdate", roomService.get10RoomRecentUpdates());
        model.addAttribute("contractPhone", userService.getAdmin().getPhoneNumber());

        Invoice invoice = Invoice.builder()
                .billingPeriodMonth(LocalDate.now().getMonthValue() + 1)
                .billingPeriodYear(LocalDate.now().getYear())
                .totalAmount(new BigDecimal(10000000))
                .build();

        return "home";
    }

    @GetMapping(value = "/payment/success")
    public String clientPage(Model model) {

        return "hello";
    }

}