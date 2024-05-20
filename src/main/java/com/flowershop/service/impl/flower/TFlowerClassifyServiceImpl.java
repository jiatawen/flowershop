package com.flowershop.service.impl.flower;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.flower.TFlowerClassifyDao;
import com.flowershop.entity.flower.TFlowerClassify;
import com.flowershop.service.flower.TFlowerClassifyService;
import org.springframework.stereotype.Service;

/**
 * 鲜花分类，鲜花连理表(TFlowerClassify)表服务实现类
 *
 * @author makejava
 * @since 2024-05-20 19:31:44
 */
@Service("tFlowerClassifyService")
public class TFlowerClassifyServiceImpl extends ServiceImpl<TFlowerClassifyDao, TFlowerClassify> implements TFlowerClassifyService {

}

