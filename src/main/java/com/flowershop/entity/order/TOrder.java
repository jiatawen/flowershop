package com.flowershop.entity.order;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * 订单表;(TOrder)表实体类
 *
 * @author makejava
 * @since 2024-05-20 19:31:45
 */
@SuppressWarnings("serial")
public class TOrder extends Model<TOrder> {
    //订单id
    @TableId("o_id")
    private Integer oId;
    //用户id
    private Integer uId;
    //收货人姓名
    private String oName;
    //收货人电话
    private String oTel;
    //收货地址
    private String oAddress;
    //备注
    private String oNotes;
    //创建时间
    private Date oCreateTime;
    //总价
    private BigDecimal oSumPrice;
    //订单状态;0为待付款，1为已付款未发货，2为已发货，3为待评价，4为结单
    private String oStatus;


    public Integer getOId() {
        return oId;
    }

    public void setOId(Integer oId) {
        this.oId = oId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getOName() {
        return oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }

    public String getOTel() {
        return oTel;
    }

    public void setOTel(String oTel) {
        this.oTel = oTel;
    }

    public String getOAddress() {
        return oAddress;
    }

    public void setOAddress(String oAddress) {
        this.oAddress = oAddress;
    }

    public String getONotes() {
        return oNotes;
    }

    public void setONotes(String oNotes) {
        this.oNotes = oNotes;
    }

    public Date getOCreateTime() {
        return oCreateTime;
    }

    public void setOCreateTime(Date oCreateTime) {
        this.oCreateTime = oCreateTime;
    }

    public BigDecimal getOSumPrice() {
        return oSumPrice;
    }

    public void setOSumPrice(BigDecimal oSumPrice) {
        this.oSumPrice = oSumPrice;
    }

    public String getOStatus() {
        return oStatus;
    }

    public void setOStatus(String oStatus) {
        this.oStatus = oStatus;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.oId;
    }
}

