package com.flowershop.entity;

import java.io.Serializable;

/**
 * (TFenlei)实体类
 *
 * @author makejava
 * @since 2024-04-01 23:48:22
 */
public class TFenlei implements Serializable {
    private static final long serialVersionUID = 496081787798824667L;

    private Integer id;

    private String fname;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

}

