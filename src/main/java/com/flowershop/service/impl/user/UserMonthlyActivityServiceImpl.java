package com.flowershop.service.impl.user;

import com.flowershop.dao.user.UserMonthlyActivityDao;
import com.flowershop.entity.user.UserMonthlyActivity;
import com.flowershop.service.user.UserMonthlyActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userMonthlyActivityService")
public class UserMonthlyActivityServiceImpl implements UserMonthlyActivityService {
    @Resource
    private UserMonthlyActivityDao userMonthlyActivityDao;
    @Override
    public List<UserMonthlyActivity> selectByUId(Long uId) {
        return userMonthlyActivityDao.selectByUId(uId);
    }
}
