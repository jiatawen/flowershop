package com.flowershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String hello(){
        return "/index.html";
    }

    @RequestMapping("/")
    public String logout(){
        return "/index.html";
    }
}
