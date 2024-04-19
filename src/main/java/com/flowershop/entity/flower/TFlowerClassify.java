package com.flowershop.entity.flower;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 鲜花分类(TFlowerClassify)表实体类
 *
 * @author makejava
 * @since 2024-04-20 01:43:36
 */
@SuppressWarnings("serial")
public class TFlowerClassify extends Model<TFlowerClassify> {
    //表id
    private Integer fcId;
    //鲜花id
    private Integer fId;
    //鲜花颜色
    private String fcColor;
    //鲜花寓意
    private String fcImplication;
    //品种
    private String fcVariety;


    public Integer getFcId() {
        return fcId;
    }

    public void setFcId(Integer fcId) {
        this.fcId = fcId;
    }

    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }

    public String getFcColor() {
        return fcColor;
    }

    public void setFcColor(String fcColor) {
        this.fcColor = fcColor;
    }

    public String getFcImplication() {
        return fcImplication;
    }

    public void setFcImplication(String fcImplication) {
        this.fcImplication = fcImplication;
    }

    public String getFcVariety() {
        return fcVariety;
    }

    public void setFcVariety(String fcVariety) {
        this.fcVariety = fcVariety;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.fcId;
    }
}

