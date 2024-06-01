package com.flowershop.service.impl.user;

import com.flowershop.dao.user.TUserDao;
import com.flowershop.entity.user.TUser;
import com.flowershop.service.user.EmailService;
import com.flowershop.service.user.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class registerServiceImpl implements RegisterService {

    @Resource
    private TUserDao userDao;
    @Resource
    private EmailService emailService;


    @Override
    public Integer register(TUser user, String code) {
        if (!emailService.check(code, user.getUMail())) {
            return 0;
        } else {
            List<TUser> users = new ArrayList<>();
            users.add(user);
            userDao.insertBatch(users);
        }
        return 1;
    }

}
