package com.flowershop.entity.order;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 订单详情表;(TOrderDetails)表实体类
 *
 * @author makejava
 * @since 2024-05-20 19:31:45
 */
@SuppressWarnings("serial")
public class TOrderDetails extends Model<TOrderDetails> {
    //表id
    private Integer id;
    //订单号
    private Integer oId;
    //鲜花id
    private Integer fId;
    //鲜花数目
    private Integer odCount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOId() {
        return oId;
    }

    public void setOId(Integer oId) {
        this.oId = oId;
    }

    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }

    public Integer getOdCount() {
        return odCount;
    }

    public void setOdCount(Integer odCount) {
        this.odCount = odCount;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

