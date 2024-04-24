package com.flowershop.controller.user;

import com.flowershop.entity.user.TUser;
import com.flowershop.service.user.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping
    public TUser login(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletResponse response, HttpServletRequest request) {
        System.out.println("controller层login被调用");
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30 * 60);
        TUser user = loginService.login(email, password);

        try {
            if (user != null) {
                session.setAttribute("user", user);
                response.sendRedirect("/user/index/index.html");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
