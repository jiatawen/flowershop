package com.flowershop.entity.order;


import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 购物车;(TCart)表实体类
 *
 * @author makejava
 * @since 2024-05-20 19:31:41
 */
public class TCartVO extends Model<TCartVO> {
    private Integer id;
    //鲜花名称
    private String name;
    //购买数量
    private Integer number;
    //单价
    private String price;
    //小记价格
    private String totalPrice;

    public TCartVO(Integer id, String name, Integer number, String price, String totalPrice) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public TCartVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}

