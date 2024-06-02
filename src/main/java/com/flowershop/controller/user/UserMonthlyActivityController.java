package com.flowershop.controller.user;

import com.flowershop.entity.user.UserMonthlyActivity;
import com.flowershop.service.user.UserMonthlyActivityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("userMonthlyActivety")
public class UserMonthlyActivityController {
    @Resource
    private UserMonthlyActivityService userMonthlyActivityService;

    @GetMapping
    public List<UserMonthlyActivity> userMonthlyActivity(Long uId) {
        System.out.println(uId);
        return userMonthlyActivityService.selectByUId(uId);
    }
}
