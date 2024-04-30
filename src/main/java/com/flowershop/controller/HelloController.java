package com.flowershop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class HelloController {
    @GetMapping
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/user/index/index.html");
    }
}
