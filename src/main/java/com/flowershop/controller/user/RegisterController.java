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
    public Integer register(@RequestParam("name") String name, @RequestParam("password") String password,@RequestParam("email") String email, @RequestParam("code") String code,@RequestParam("status") String status){
        TUser user = new TUser();
        user.setUName(name);
        user.setUPassword(password);
        user.setUMail(email);
        user.setUStatus(status);
        return registerService.register(user, code);
    }
}
