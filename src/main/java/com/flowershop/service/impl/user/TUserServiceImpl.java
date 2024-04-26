package com.flowershop.service.impl.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.user.TUserDao;
import com.flowershop.entity.user.TUser;
import com.flowershop.service.user.GetHexService;
import com.flowershop.service.user.TUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户表;(TUser)表服务实现类
 *
 * @author makejava
 * @since 2024-04-20 01:43:38
 */
@Service("tUserService")
public class TUserServiceImpl extends ServiceImpl<TUserDao, TUser> implements TUserService {

    @Resource
    private TUserDao tUserDao;
    @Resource
    private EmailServiceImpl emailService;
    @Resource
    private GetHexService getHexService;

    @Override
    public Integer ResetPassword(String email, String code, String password) {
        TUser tUser = tUserDao.selectByEmail(email);
        if (tUser!= null) {
            if (emailService.checkCode(code)) {
                tUserDao.resetPassword(tUser.getUId(), getHexService.getHex(password));
                return 1;
            }
            return 0;
        }
        return -1;
    }
}

