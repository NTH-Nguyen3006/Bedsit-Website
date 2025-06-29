package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class helloController {

    @GetMapping("/")
    public String Hello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        System.out.println(12312124);
        model.addAttribute("name", name);
        return "hello";
    }
}
