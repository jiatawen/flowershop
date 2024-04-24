package com.flowershop.service.impl.user;

import com.flowershop.dao.user.TUserDao;
import com.flowershop.entity.user.TUser;
import com.flowershop.service.user.EmailService;
import com.flowershop.service.user.GetHexService;
import com.flowershop.service.user.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class registerServiceImpl implements RegisterService {

    @Resource
    private TUserDao  userDao;
    @Resource
    private EmailService emailService;
    @Resource
    private GetHexService getHexService;
    @Override
    public Integer register(TUser user,String code) {
        System.out.println(user.getUMail());
        if (userDao.selectByEmail(user.getUMail())!=null) {
            return 1;
        }
        if (!emailService.register(code,user.getUMail())) {
            return 2;
        } else {
            user.setUPassword(getHexService.getHex(user.getUPassword()));
            userDao.insertUser(user);
        }
        return 0;
    }
}
