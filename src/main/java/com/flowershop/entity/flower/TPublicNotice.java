package com.flowershop.entity.flower;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 公告(TPublicNotice)表实体类
 *
 * @author makejava
 * @since 2024-05-20 19:31:46
 */
@SuppressWarnings("serial")
public class TPublicNotice extends Model<TPublicNotice> {
    //公告id
    private Integer pnId;
    //公告内容
    private String pnContent;
    //开始时间
    private Date pnStartTime;
    //结束时间
    private Date pnEndTime;


    public Integer getPnId() {
        return pnId;
    }

    public void setPnId(Integer pnId) {
        this.pnId = pnId;
    }

    public String getPnContent() {
        return pnContent;
    }

    public void setPnContent(String pnContent) {
        this.pnContent = pnContent;
    }

    public Date getPnStartTime() {
        return pnStartTime;
    }

    public void setPnStartTime(Date pnStartTime) {
        this.pnStartTime = pnStartTime;
    }

    public Date getPnEndTime() {
        return pnEndTime;
    }

    public void setPnEndTime(Date pnEndTime) {
        this.pnEndTime = pnEndTime;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.pnId;
    }
}

