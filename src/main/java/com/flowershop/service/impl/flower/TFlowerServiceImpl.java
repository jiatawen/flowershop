package com.flowershop.service.impl.flower;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.flower.TFlowerDao;
import com.flowershop.entity.flower.TFlower;
import com.flowershop.service.flower.TFlowerService;
import org.springframework.stereotype.Service;

/**
 * 鲜花;(TFlower)表服务实现类
 *
 * @author makejava
 * @since 2024-05-20 19:31:43
 */
@Service("tFlowerService")
public class TFlowerServiceImpl extends ServiceImpl<TFlowerDao, TFlower> implements TFlowerService {

}

