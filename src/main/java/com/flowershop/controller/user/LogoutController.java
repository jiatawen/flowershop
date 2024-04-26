package com.flowershop.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/logout")
public class LogoutController {
    @GetMapping
    public Integer logout(HttpServletRequest request) {
        //清空session
        request.getSession().removeAttribute("user");
        return 0;
    }
}
