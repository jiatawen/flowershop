package com.flowershop.entity.user;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 收货联系方式表;(TUserContact)表实体类
 *
 * @author makejava
 * @since 2024-04-20 01:43:39
 */
@SuppressWarnings("serial")
public class TUserContact extends Model<TUserContact> {
    //表id
    private Integer id;
    //用户id
    private Integer uId;
    //收货人
    private String ucName;
    //收货地址信息
    private String ucAddress;
    //收货人联系方式
    private String ucTel;


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

    public String getUcName() {
        return ucName;
    }

    public void setUcName(String ucName) {
        this.ucName = ucName;
    }

    public String getUcAddress() {
        return ucAddress;
    }

    public void setUcAddress(String ucAddress) {
        this.ucAddress = ucAddress;
    }

    public String getUcTel() {
        return ucTel;
    }

    public void setUcTel(String ucTel) {
        this.ucTel = ucTel;
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

