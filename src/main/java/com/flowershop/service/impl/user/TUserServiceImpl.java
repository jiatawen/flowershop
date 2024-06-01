package com.flowershop.service.impl.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.user.TUserDao;
import com.flowershop.entity.user.TUser;
import com.flowershop.service.user.EmailService;
import com.flowershop.service.user.GetHexService;
import com.flowershop.service.user.TUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户表;(TUser)表服务实现类
 *
 * @author makejava
 * @since 2024-05-20 19:54:58
 */
@Service("tUserService")
public class TUserServiceImpl extends ServiceImpl<TUserDao, TUser> implements TUserService {

    @Resource
    private EmailService emailService;
    @Resource
    private TUserDao tUserDao;
    @Resource
    private GetHexService getHexService;

    @Override
    public Integer resetPassword(String email, String code, String password) {
        if (emailService.check(code, email)) {
            TUser user = tUserDao.findByEmail(email);

            if (user != null) {
                user.setUPassword(getHexService.getHex(password));
                tUserDao.updateById(user);
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }
}

