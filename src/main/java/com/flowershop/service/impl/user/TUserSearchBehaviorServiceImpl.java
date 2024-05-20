package com.flowershop.service.impl.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.user.TUserSearchBehaviorDao;
import com.flowershop.entity.user.TUserSearchBehavior;
import com.flowershop.service.user.TUserSearchBehaviorService;
import org.springframework.stereotype.Service;

/**
 * 用户搜索行为记录表;(TUserSearchBehavior)表服务实现类
 *
 * @author makejava
 * @since 2024-05-20 19:55:00
 */
@Service("tUserSearchBehaviorService")
public class TUserSearchBehaviorServiceImpl extends ServiceImpl<TUserSearchBehaviorDao, TUserSearchBehavior> implements TUserSearchBehaviorService {

}

