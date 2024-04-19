package com.flowershop.service.impl.order;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.order.TOrderDao;
import com.flowershop.entity.order.TOrder;
import com.flowershop.service.order.TOrderService;
import org.springframework.stereotype.Service;

/**
 * 订单表;(TOrder)表服务实现类
 *
 * @author makejava
 * @since 2024-04-20 01:43:37
 */
@Service("tOrderService")
public class TOrderServiceImpl extends ServiceImpl<TOrderDao, TOrder> implements TOrderService {

}

