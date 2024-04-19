package com.flowershop.service.impl.flower;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.flower.TFlowerClassifyDao;
import com.flowershop.entity.flower.TFlowerClassify;
import com.flowershop.service.flower.TFlowerClassifyService;
import org.springframework.stereotype.Service;

/**
 * 鲜花分类(TFlowerClassify)表服务实现类
 *
 * @author makejava
 * @since 2024-04-20 01:43:36
 */
@Service("tFlowerClassifyService")
public class TFlowerClassifyServiceImpl extends ServiceImpl<TFlowerClassifyDao, TFlowerClassify> implements TFlowerClassifyService {

}

