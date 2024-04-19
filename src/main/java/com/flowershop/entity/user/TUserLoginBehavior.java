package com.flowershop.entity.user;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.sql.Date;
import java.io.Serializable;

/**
 * 用户登录行为记录表;(TUserLoginBehavior)表实体类
 *
 * @author makejava
 * @since 2024-04-20 01:43:39
 */
@SuppressWarnings("serial")
public class TUserLoginBehavior extends Model<TUserLoginBehavior> {
    //表id
    private Integer id;
    //用户id
    private Integer uId;
    //用户操作;登录0/登出1
    private String ulbType;
    //时间
    private Date ulbTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUlbType() {
        return ulbType;
    }

    public void setUlbType(String ulbType) {
        this.ulbType = ulbType;
    }

    public Date getUlbTime() {
        return ulbTime;
    }

    public void setUlbTime(Date ulbTime) {
        this.ulbTime = ulbTime;
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

