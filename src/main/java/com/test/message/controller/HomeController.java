package com.test.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:8080")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "notifications"; }
}
