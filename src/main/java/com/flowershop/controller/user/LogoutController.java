package com.flowershop.controller.user;

import com.flowershop.entity.user.TUser;
import com.flowershop.service.user.TUserLoginBehaviorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/logout")
public class LogoutController {

    @Resource
    private TUserLoginBehaviorService tUserLoginBehaviorService;

    @GetMapping
    public Integer logout(HttpServletRequest request) {
        TUser user = (TUser)request.getSession().getAttribute("user");
//        tUserLoginBehaviorService.insert(user, 1);
        //清空session
        request.getSession().removeAttribute("user");

        return 0;
    }
}
