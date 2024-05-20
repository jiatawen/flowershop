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
 * @since 2024-05-20 19:31:42
 */
@Service("tCartService")
public class TCartServiceImpl extends ServiceImpl<TCartDao, TCart> implements TCartService {

}

