package com.flowershop.entity.order;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表;(TOrder)表实体类
 *
 * @author makejava
 * @since 2024-05-20 19:31:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TOrder extends Model<TOrder> {
    //订单id
    @TableId(value = "o_id", type = IdType.AUTO)
    private Long oId;
    //用户id
    private Integer uId;
    //收货人姓名
    private String oName;
    //收货人电话
    private String oTel;
    //收货地址
    private String oAddress;
    //备注
    private String oNotes;
    //创建时间
    private Date oCreateTime;
    //总价
    private BigDecimal oSumPrice;
    //订单状态;0为待付款，1为已付款未发货，2为已发货，3为待评价，4为结单
    private String oStatus;

}

