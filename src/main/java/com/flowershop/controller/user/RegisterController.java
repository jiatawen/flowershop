package com.flowershop.controller.user;

import com.flowershop.entity.user.TUser;
import com.flowershop.service.user.RegisterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Resource
    private RegisterService registerService;


    @PostMapping
    public Integer register(String email, String name, String password, String code) {
        TUser user = new TUser();
        System.out.println(email);
        System.out.println("register c层被调用");
        user.setUName(name);
        user.setUPassword(password);
        user.setUMail(email);
        System.out.println(user.getUMail());
        return registerService.register(user, code);
    }
}
