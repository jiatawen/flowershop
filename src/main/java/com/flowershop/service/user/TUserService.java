package com.flowershop.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.flowershop.entity.user.TUser;

/**
 * 用户表;(TUser)表服务接口
 *
 * @author makejava
 * @since 2024-04-20 01:43:38
 */
public interface TUserService extends IService<TUser> {

    Integer ResetPassword(String email, String code, String password);
}

