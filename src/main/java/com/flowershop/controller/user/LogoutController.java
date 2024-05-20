package com.flowershop.controller.user;

import com.flowershop.dao.user.TUserLoginBehaviorDao;
import com.flowershop.entity.user.TUser;
import com.flowershop.entity.user.TUserLoginBehavior;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/logout")
public class LogoutController {

    @Resource
    private TUserLoginBehaviorDao loginBehaviorDao;

    @GetMapping
    public Integer logout(HttpServletRequest request) {
        TUser user = (TUser) request.getSession().getAttribute("user");
        TUserLoginBehavior data = new TUserLoginBehavior();
        data.setUId(user.getUId());
        data.setUlbType("1");
        List<TUserLoginBehavior> datas = new ArrayList<>();
        datas.add(data);
        loginBehaviorDao.insertBatch(datas);
        //清空session
        request.getSession().removeAttribute("user");

        return 0;
    }
}
