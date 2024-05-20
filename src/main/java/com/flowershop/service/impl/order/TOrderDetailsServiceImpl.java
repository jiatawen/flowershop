package com.flowershop.service.impl.order;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.order.TOrderDetailsDao;
import com.flowershop.entity.order.TOrderDetails;
import com.flowershop.service.order.TOrderDetailsService;
import org.springframework.stereotype.Service;

/**
 * 订单详情表;(TOrderDetails)表服务实现类
 *
 * @author makejava
 * @since 2024-05-20 19:31:46
 */
@Service("tOrderDetailsService")
public class TOrderDetailsServiceImpl extends ServiceImpl<TOrderDetailsDao, TOrderDetails> implements TOrderDetailsService {

}

