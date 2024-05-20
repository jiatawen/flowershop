package com.flowershop.entity.flower;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 鲜花分类，鲜花连理表(TFlowerClassify)表实体类
 *
 * @author makejava
 * @since 2024-05-20 19:31:44
 */
@SuppressWarnings("serial")
public class TFlowerClassify extends Model<TFlowerClassify> {
    //表id
    private Integer id;
    //鲜花id
    private Integer fId;
    //公告id
    private Integer cId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

