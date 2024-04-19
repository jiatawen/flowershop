package com.flowershop.service.impl.flower;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.flower.TPublicNoticeDao;
import com.flowershop.entity.flower.TPublicNotice;
import com.flowershop.service.flower.TPublicNoticeService;
import org.springframework.stereotype.Service;

/**
 * 公告(TPublicNotice)表服务实现类
 *
 * @author makejava
 * @since 2024-04-20 01:43:38
 */
@Service("tPublicNoticeService")
public class TPublicNoticeServiceImpl extends ServiceImpl<TPublicNoticeDao, TPublicNotice> implements TPublicNoticeService {

}

