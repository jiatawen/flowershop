package com.flowershop.controller.user;

import com.flowershop.dao.user.TUserLoginBehaviorDao;
import com.flowershop.entity.user.TUser;
import com.flowershop.entity.user.TUserLoginBehavior;
import com.flowershop.service.user.ChatService;
import com.flowershop.service.user.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("login")
public class LoginController {

    @Resource
    private LoginService loginService;
    @Resource
    private TUserLoginBehaviorDao loginBehaviorDao;

    @Resource
    private ChatService chatService;

    @GetMapping
    public TUser login(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30 * 60);
        TUser user = loginService.login(email, password);

        try {
            if (user != null) {
                session.setAttribute("user", user);
                TUserLoginBehavior data = new TUserLoginBehavior();
                data.setUId(user.getUId());
                data.setUlbType("0");
                List<TUserLoginBehavior> datas = new ArrayList<>();
                datas.add(data);
                loginBehaviorDao.insertBatch(datas);
            } else {
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
