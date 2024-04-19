package com.flowershop.entity.order;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 购物车;(TCart)表实体类
 *
 * @author makejava
 * @since 2024-04-20 01:43:35
 */
@SuppressWarnings("serial")
public class TCart extends Model<TCart> {
    //序号id
    private Integer id;
    //用户id
    private Integer uId;
    //鲜花id
    private Integer fId;
    //购买数量
    private Integer cCount;
    //状态;0为鲜花下架，1为正常状态
    private String cStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }

    public Integer getCCount() {
        return cCount;
    }

    public void setCCount(Integer cCount) {
        this.cCount = cCount;
    }

    public String getCStatus() {
        return cStatus;
    }

    public void setCStatus(String cStatus) {
        this.cStatus = cStatus;
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

