package com.flowershop.entity.user;

import java.io.Serializable;

/**
 * 收货联系方式表;(TUserContact)实体类
 *
 * @author makejava
 * @since 2024-04-26 13:01:52
 */
public class TUserContact implements Serializable {
    private static final long serialVersionUID = -73883725986799159L;
    /**
     * 表id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer uId;
    /**
     * 收货人
     */
    private String ucName;
    /**
     * 收货地址信息
     */
    private String ucAddress;
    /**
     * 收货人联系方式
     */
    private String ucTel;
    /**
     * 默认地址为0
     */
    private Integer ucStatus;


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

    public Integer getUcStatus() {
        return ucStatus;
    }

    public void setUcStatus(Integer ucStatus) {
        this.ucStatus = ucStatus;
    }

}

