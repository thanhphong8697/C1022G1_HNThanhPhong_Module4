package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping("/caculator")
    public String display() {
        return "/caculator";
    }

    @PostMapping("/caculator")
    public String caculate(@RequestParam double numb1, @RequestParam double numb2, @RequestParam String method, Model model) {
        double result = 0;
        switch (method) {
            case "addition":
                result = numb1 + numb2;
                break;
            case "subtraction":
                result = numb1 - numb2;
                break;
            case "multiplication":
                result = numb1 * numb2;
                break;
            case "division":

                result = numb1 / numb2;
                break;
        }
        model.addAttribute("result", result);
        return "/caculator";
    }

}
