package com.flowershop.entity.flower;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 鲜花;(TFlower)表实体类
 *
 * @author makejava
 * @since 2024-05-20 19:31:43
 */
@SuppressWarnings("serial")
public class TFlower extends Model<TFlower> {
    //鲜花id
    @TableId("f_id")
    private Integer fId;
    //鲜花名称
    private String fName;
    //鲜花寓意
    private String fImplication;
    //鲜花颜色
    private String fColor;
    //鲜花图片
    private String fImg;
    //鲜花价格
    private BigDecimal fPrice;
    //鲜花数量
    private String fNumber;


    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFImplication() {
        return fImplication;
    }

    public void setFImplication(String fImplication) {
        this.fImplication = fImplication;
    }

    public String getFColor() {
        return fColor;
    }

    public void setFColor(String fColor) {
        this.fColor = fColor;
    }

    public String getFImg() {
        return fImg;
    }

    public void setFImg(String fImg) {
        this.fImg = fImg;
    }

    public BigDecimal getFPrice() {
        return fPrice;
    }

    public void setFPrice(BigDecimal fPrice) {
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

