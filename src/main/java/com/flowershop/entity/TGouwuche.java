package com.flowershop.entity;

import java.io.Serializable;

/**
 * (TGouwuche)实体类
 *
 * @author makejava
 * @since 2024-04-01 23:48:23
 */
public class TGouwuche implements Serializable {
    private static final long serialVersionUID = -16262736335978638L;

    private Integer id;

    private Integer userid;

    private Integer pid;

    private Integer shuliang;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getShuliang() {
        return shuliang;
    }

    public void setShuliang(Integer shuliang) {
        this.shuliang = shuliang;
    }

}

