package com.flowershop.dao.user;

import com.flowershop.entity.user.UserMonthlyActivity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMonthlyActivityDao{
    List<UserMonthlyActivity> selectByUId(Long uId);
}
