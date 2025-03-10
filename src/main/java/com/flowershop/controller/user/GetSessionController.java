package com.flowershop.controller.user;

import com.flowershop.entity.user.TUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//该方法是提供当前登录用户的登录信息
@RestController
@RequestMapping("/getSession")
public class GetSessionController {
    @GetMapping
    public TUser getSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        return (TUser)session.getAttribute("user");
    }
}
