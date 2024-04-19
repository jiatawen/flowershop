package com.flowershop.service.impl.order;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.order.TCartDao;
import com.flowershop.entity.order.TCart;
import com.flowershop.service.order.TCartService;
import org.springframework.stereotype.Service;

/**
 * 购物车;(TCart)表服务实现类
 *
 * @author makejava
 * @since 2024-04-20 01:43:35
 */
@Service("tCartService")
public class TCartServiceImpl extends ServiceImpl<TCartDao, TCart> implements TCartService {

}

