package com.flowershop.service.impl.flower;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.flower.TClassifyDao;
import com.flowershop.entity.flower.TClassify;
import com.flowershop.service.flower.TClassifyService;
import org.springframework.stereotype.Service;

/**
 * 鲜花分类(TClassify)表服务实现类
 *
 * @author makejava
 * @since 2024-05-20 19:31:42
 */
@Service("tClassifyService")
public class TClassifyServiceImpl extends ServiceImpl<TClassifyDao, TClassify> implements TClassifyService {

}

