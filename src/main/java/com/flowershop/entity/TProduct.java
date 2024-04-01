package com.flowershop.entity;

import java.io.Serializable;

/**
 * (TProduct)实体类
 *
 * @author makejava
 * @since 2024-04-01 23:48:24
 */
public class TProduct implements Serializable {
    private static final long serialVersionUID = -21957212842898669L;

    private Integer id;

    private String pname;

    private String imgpath;

    private String createtime;

    private Integer fenleiid;

    private Object jiage;

    private String tuijian;

    private String miaoshu;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getFenleiid() {
        return fenleiid;
    }

    public void setFenleiid(Integer fenleiid) {
        this.fenleiid = fenleiid;
    }

    public Object getJiage() {
        return jiage;
    }

    public void setJiage(Object jiage) {
        this.jiage = jiage;
    }

    public String getTuijian() {
        return tuijian;
    }

    public void setTuijian(String tuijian) {
        this.tuijian = tuijian;
    }

    public String getMiaoshu() {
        return miaoshu;
    }

    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu;
    }

}

