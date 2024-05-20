package com.flowershop.entity.flower;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 鲜花分类(TClassify)表实体类
 *
 * @author makejava
 * @since 2024-05-20 19:31:42
 */
@SuppressWarnings("serial")
public class TClassify extends Model<TClassify> {
    //公告id
    private Integer cId;
    //品种
    private String cVariety;


    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCVariety() {
        return cVariety;
    }

    public void setCVariety(String cVariety) {
        this.cVariety = cVariety;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.cId;
    }
}

