package com.flowershop.service.impl.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.user.TUserDao;
import com.flowershop.entity.user.TUser;
import com.flowershop.service.user.TUserService;
import org.springframework.stereotype.Service;

/**
 * 用户表;(TUser)表服务实现类
 *
 * @author makejava
 * @since 2024-05-20 19:54:58
 */
@Service("tUserService")
public class TUserServiceImpl extends ServiceImpl<TUserDao, TUser> implements TUserService {

}

