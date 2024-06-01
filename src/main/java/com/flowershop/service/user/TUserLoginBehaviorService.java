package com.flowershop.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.flowershop.entity.user.TUserLoginBehavior;
import com.flowershop.entity.user.VUserLogin;

/**
 * 用户登录行为记录表;(TUserLoginBehavior)表服务接口
 *
 * @author makejava
 * @since 2024-05-20 19:54:59
 */
public interface TUserLoginBehaviorService extends IService<TUserLoginBehavior> {

    VUserLogin getPerMonth(Integer uid);
}

