package com.flowershop.controller.user;

import com.flowershop.entity.user.TUser;
import com.flowershop.service.user.ChatService;
import com.flowershop.service.user.LoginService;
import com.flowershop.service.user.TUserLoginBehaviorService;
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
    @Resource
    private TUserLoginBehaviorService tUserLoginBehaviorService;

    @Resource
    private ChatService chatService;

    @GetMapping
    public TUser login(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30 * 60);
        TUser user = loginService.login(email, password);

        try {
            if (user != null) {
//                tUserLoginBehaviorService.(user, 0);
                session.setAttribute("user", user);
            }else {
                //向浏览器抛出404异常
                response.sendError(404);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
