package com.flowershop.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TDingdan)实体类
 *
 * @author makejava
 * @since 2024-04-01 23:48:20
 */
public class TDingdan implements Serializable {
    private static final long serialVersionUID = -20063747710312573L;

    private Integer id;

    private String orderid;

    private String status;

    private Integer userid;

    private Integer pid;

    private Integer shumu;

    private String dianhua;

    private String dizhi;

    private String beizhu;

    private Date shijian;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getShumu() {
        return shumu;
    }

    public void setShumu(Integer shumu) {
        this.shumu = shumu;
    }

    public String getDianhua() {
        return dianhua;
    }

    public void setDianhua(String dianhua) {
        this.dianhua = dianhua;
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public Date getShijian() {
        return shijian;
    }

    public void setShijian(Date shijian) {
        this.shijian = shijian;
    }

}

