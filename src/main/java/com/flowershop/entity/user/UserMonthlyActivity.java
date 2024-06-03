package com.flowershop.entity.user;

import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;

public class UserMonthlyActivity {
    @TableId("u_id")
    private Long uId;
    private String month;
    private Integer orderCount;
    private BigDecimal totalSumPrice;
    private Integer loginTimes;

    public UserMonthlyActivity() {
    }

    public UserMonthlyActivity(Long uId, String month, Integer orderCount, BigDecimal totalSumPrice, Integer loginTimes) {
        this.uId = uId;
        this.month = month;
        this.orderCount = orderCount;
        this.totalSumPrice = totalSumPrice;
        this.loginTimes = loginTimes;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public BigDecimal getTotalSumPrice() {
        return totalSumPrice;
    }

    public void setTotalSumPrice(BigDecimal totalSumPrice) {
        this.totalSumPrice = totalSumPrice;
    }

    public Integer getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    @Override
    public String toString() {
        return "UserMonthlyActivity{" +
                "uId=" + uId +
                ", month='" + month + '\'' +
                ", orderCount=" + orderCount +
                ", totalSumPrice=" + totalSumPrice +
                ", loginTimes=" + loginTimes +
                '}';
    }
}
