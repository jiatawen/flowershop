package com.flowershop.entity.user;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 用户表;(TUser)表实体类
 *
 * @author makejava
 * @since 2024-05-20 19:54:58
 */
@SuppressWarnings("serial")
public class TUser extends Model<TUser> {
    //用户id
    private Integer uId;
    //用户名
    private String uName;
    //身份标识;管理员0/普通买家1
    private String uStatus;
    //用户密码
    private String uPassword;
    //用户邮箱
    private String uMail;
    //用户期望
    private Double uExpect;
    //创建时间
    private Date uCreatTime;


    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUStatus() {
        return uStatus;
    }

    public void setUStatus(String uStatus) {
        this.uStatus = uStatus;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getUMail() {
        return uMail;
    }

    public void setUMail(String uMail) {
        this.uMail = uMail;
    }

    public Double getUExpect() {
        return uExpect;
    }

    public void setUExpect(Double uExpect) {
        this.uExpect = uExpect;
    }

    public Date getUCreatTime() {
        return uCreatTime;
    }

    public void setUCreatTime(Date uCreatTime) {
        this.uCreatTime = uCreatTime;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.uId;
    }
}

