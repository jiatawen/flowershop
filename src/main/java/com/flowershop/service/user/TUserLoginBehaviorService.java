package com.flowershop.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.flowershop.entity.user.TUser;
import com.flowershop.entity.user.TUserLoginBehavior;

import javax.mail.MessagingException;

/**
 * 用户登录行为记录表;(TUserLoginBehavior)表服务接口
 *
 * @author makejava
 * @since 2024-04-20 01:43:39
 */
public interface TUserLoginBehaviorService extends IService<TUserLoginBehavior> {
//    登录实现
    public TUser login(String uEmail, String uPassword);
//    发送邮件
    public void sendEmail(String email) throws MessagingException, Exception;
}

