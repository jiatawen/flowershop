package com.flowershop.entity;

import java.io.Serializable;

/**
 * (TGonggao)实体类
 *
 * @author makejava
 * @since 2024-04-01 23:48:22
 */
public class TGonggao implements Serializable {
    private static final long serialVersionUID = -49657508524797473L;

    private Integer id;

    private String biaoti;

    private String neirong;

    private String shijian;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBiaoti() {
        return biaoti;
    }

    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

}

