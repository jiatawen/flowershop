package com.flowershop.service.impl.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.user.TUserContactDao;
import com.flowershop.entity.user.TUserContact;
import com.flowershop.service.user.TUserContactService;
import org.springframework.stereotype.Service;

/**
 * 收货联系方式表;(TUserContact)表服务实现类
 *
 * @author makejava
 * @since 2024-05-20 19:54:59
 */
@Service("tUserContactService")
public class TUserContactServiceImpl extends ServiceImpl<TUserContactDao, TUserContact> implements TUserContactService {

}

