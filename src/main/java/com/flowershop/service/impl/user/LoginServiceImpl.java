package com.flowershop.service.impl.user;

import com.flowershop.dao.user.TUserDao;
import com.flowershop.entity.user.TUser;
import com.flowershop.service.user.GetHexService;
import com.flowershop.service.user.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private TUserDao tUserDao;

    @Resource
    private GetHexService getHexService;

    @Override
    public TUser login(String email, String password) {
        System.out.println("service层login被调用");
        System.out.println("账户:"+email+"密码:"+password);
        TUser tUser = tUserDao.selectByEmail(email);
        System.out.println(tUser);
        if (tUser == null) {
            return null;
        }else if(tUser.getUPassword().equals(getHexService.getHex(password))) {
            return tUser;
        }else return null;
    }
}
