package com.flowershop.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.flowershop.entity.user.TUser;

/**
 * 用户表;(TUser)表服务接口
 *
 * @author makejava
 * @since 2024-05-20 19:54:58
 */
public interface TUserService extends IService<TUser> {

    Integer resetPassword(String email, String code, String password);
}

