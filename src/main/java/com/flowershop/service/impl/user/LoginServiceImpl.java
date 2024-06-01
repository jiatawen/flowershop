package com.flowershop.service.impl.user;

import com.baomidou.mybatisplus.extension.api.R;
import com.flowershop.controller.user.TUserController;
import com.flowershop.dao.user.TUserLoginBehaviorDao;
import com.flowershop.entity.user.TUser;
import com.flowershop.entity.user.TUserLoginBehavior;
import com.flowershop.service.user.GetHexService;
import com.flowershop.service.user.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private TUserController tUserController;

    @Resource
    private GetHexService getHexService;

    @Resource
    private TUserLoginBehaviorDao tUserLoginBehavior;

    @Override
    public TUser login(String email, String password) {
        R tUser = tUserController.selectByEmail(email);
        TUser user = (TUser) tUser.getData();
        if (tUser == null) {
            return null;
        } else if (user.getUPassword().equals(getHexService.getHex(password))) {
            TUserLoginBehavior data = new TUserLoginBehavior();
            data.setUId(user.getUId());
            data.setUlbType("0");
            List<TUserLoginBehavior> datas = new ArrayList<>();
            datas.add(data);
            tUserLoginBehavior.insertBatch(datas);
            return user;
        } else {
            return null;
        }
    }
}
