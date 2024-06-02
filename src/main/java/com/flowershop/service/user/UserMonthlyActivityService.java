package com.flowershop.service.user;

import com.flowershop.entity.user.UserMonthlyActivity;

import java.util.List;

public interface UserMonthlyActivityService {
    public List<UserMonthlyActivity> selectByUId(Long uId);
}
