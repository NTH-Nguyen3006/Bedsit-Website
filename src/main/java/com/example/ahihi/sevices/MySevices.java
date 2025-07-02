package com.example.ahihi.sevices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MySevices {
    @RequestMapping("/")
    public String indexPage() {
        return "23123"
    }
}