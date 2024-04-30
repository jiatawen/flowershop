package com.flowershop.entity.flower;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 鲜花;(TFlower)表实体类
 *
 * @author makejava
 * @since 2024-04-20 01:43:35
 */
@SuppressWarnings("serial")
public class TFlower extends Model<TFlower> {
    //鲜花id
    @TableId("f_id")
    private Integer fId;
    //鲜花颜色
    private String fColor;
    //鲜花价格
    private Object fPrice;
    //鲜花数量
    private String fNumber;


    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }

    public String getFColor() {
        return fColor;
    }

    public void setFColor(String fColor) {
        this.fColor = fColor;
    }

    public Object getFPrice() {
        return fPrice;
    }

    public void setFPrice(Object fPrice) {
        this.fPrice = fPrice;
    }

    public String getFNumber() {
        return fNumber;
    }

    public void setFNumber(String fNumber) {
        this.fNumber = fNumber;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.fId;
    }
}

