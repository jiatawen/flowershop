package com.flowershop.service.impl.user;

import com.baomidou.mybatisplus.extension.api.R;
import com.flowershop.controller.user.TUserController;
import com.flowershop.entity.user.TUser;
import com.flowershop.service.user.GetHexService;
import com.flowershop.service.user.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private TUserController tUserController;

    @Resource
    private GetHexService getHexService;

    @Override
    public TUser login(String email, String password) {
        System.out.println("service层login被调用");
        System.out.println("账户:"+email+"密码:"+password);
        R tUser = tUserController.selectByEmail(email);
        TUser user = (TUser) tUser.getData();
        user.setUMail(email);

        System.out.println(tUser);
        if (tUser == null) {
            return null;
        }else if(user.getUPassword().equals(getHexService.getHex(password))) {
            return user;
        }else return null;
    }
}
