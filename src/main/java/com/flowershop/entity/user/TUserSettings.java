package com.flowershop.entity.user;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 用户鲜花期望表;(TUserSettings)表实体类
 *
 * @author makejava
 * @since 2024-05-20 19:55:00
 */
@SuppressWarnings("serial")
public class TUserSettings extends Model<TUserSettings> {
    //表id
    private Integer id;
    //用户id
    private Integer uId;
    //鲜花分类id
    private Integer cId;
    //该品种鲜花期望
    private Double usExpect;


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

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public Double getUsExpect() {
        return usExpect;
    }

    public void setUsExpect(Double usExpect) {
        this.usExpect = usExpect;
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

