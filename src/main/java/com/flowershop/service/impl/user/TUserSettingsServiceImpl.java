package com.flowershop.service.impl.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.user.TUserSettingsDao;
import com.flowershop.entity.user.TUserSettings;
import com.flowershop.service.user.TUserSettingsService;
import org.springframework.stereotype.Service;

/**
 * 用户鲜花期望表;(TUserSettings)表服务实现类
 *
 * @author makejava
 * @since 2024-05-20 19:55:01
 */
@Service("tUserSettingsService")
public class TUserSettingsServiceImpl extends ServiceImpl<TUserSettingsDao, TUserSettings> implements TUserSettingsService {

}

