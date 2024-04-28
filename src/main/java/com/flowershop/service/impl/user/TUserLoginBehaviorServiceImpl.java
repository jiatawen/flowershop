package com.flowershop.service.impl.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.user.TUserLoginBehaviorDao;
import com.flowershop.entity.user.TUser;
import com.flowershop.entity.user.TUserLoginBehavior;
import com.flowershop.service.user.TUserLoginBehaviorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户登录行为记录表;(TUserLoginBehavior)表服务实现类
 *
 * @author makejava
 * @since 2024-04-20 01:43:39
 */
@Service("tUserLoginBehaviorService")
public class TUserLoginBehaviorServiceImpl extends ServiceImpl<TUserLoginBehaviorDao, TUserLoginBehavior> implements TUserLoginBehaviorService {
    @Resource
    private TUserLoginBehaviorDao tUserLoginBehaviorDao;

    @Override
    public void insert(TUser user, int status) {
        tUserLoginBehaviorDao.insert(user, status);
    }
}

