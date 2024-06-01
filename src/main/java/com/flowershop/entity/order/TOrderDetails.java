package com.flowershop.entity.order;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单详情表;(TOrderDetails)表实体类
 *
 * @author makejava
 * @since 2024-05-20 19:31:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TOrderDetails extends Model<TOrderDetails> {
    //表id
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    //订单号
    private Integer oId;
    //鲜花id
    private Integer fId;
    //鲜花数目
    private Integer odCount;
}

