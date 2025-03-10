package com.flowershop.entity.user;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 用户搜索行为记录表;(TUserSearchBehavior)表实体类
 *
 * @author makejava
 * @since 2024-05-20 19:55:00
 */
@SuppressWarnings("serial")
public class TUserSearchBehavior extends Model<TUserSearchBehavior> {
    //表id
    private Integer id;
    //用户id
    private Integer uId;
    //时间
    private Date usbTime;
    //鲜花种类id
    private Integer ftId;
    //搜索内容
    private String usbContent;


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

    public Date getUsbTime() {
        return usbTime;
    }

    public void setUsbTime(Date usbTime) {
        this.usbTime = usbTime;
    }

    public Integer getFtId() {
        return ftId;
    }

    public void setFtId(Integer ftId) {
        this.ftId = ftId;
    }

    public String getUsbContent() {
        return usbContent;
    }

    public void setUsbContent(String usbContent) {
        this.usbContent = usbContent;
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

