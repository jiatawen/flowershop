package com.flowershop.entity.flower;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 公告(TPublicNotice)表实体类
 *
 * @author makejava
 * @since 2024-04-20 01:43:38
 */
@SuppressWarnings("serial")
public class TPublicNotice extends Model<TPublicNotice> {
    //鲜花id
    private Integer pnId;
    //鲜花数目
    private Integer pnNumber;
    //鲜花价格
    private Object pnPrice;
    //鲜花品种
    private String pnVariety;


    public Integer getPnId() {
        return pnId;
    }

    public void setPnId(Integer pnId) {
        this.pnId = pnId;
    }

    public Integer getPnNumber() {
        return pnNumber;
    }

    public void setPnNumber(Integer pnNumber) {
        this.pnNumber = pnNumber;
    }

    public Object getPnPrice() {
        return pnPrice;
    }

    public void setPnPrice(Object pnPrice) {
        this.pnPrice = pnPrice;
    }

    public String getPnVariety() {
        return pnVariety;
    }

    public void setPnVariety(String pnVariety) {
        this.pnVariety = pnVariety;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.pnId;
    }
}

