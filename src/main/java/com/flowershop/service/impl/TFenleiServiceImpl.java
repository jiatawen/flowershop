package com.flowershop.service.impl;

import com.flowershop.entity.TFenlei;
import com.flowershop.dao.TFenleiDao;
import com.flowershop.service.TFenleiService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * (TFenlei)表服务实现类
 *
 * @author makejava
 * @since 2024-04-01 23:48:22
 */
@Service("tFenleiService")
public class TFenleiServiceImpl implements TFenleiService {
    @Autowired
    private TFenleiDao tFenleiDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TFenlei queryById(Integer id) {
        return this.tFenleiDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tFenlei     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<TFenlei> queryByPage(TFenlei tFenlei, PageRequest pageRequest) {
        long total = this.tFenleiDao.count(tFenlei);
        return new PageImpl<>(this.tFenleiDao.queryAllByLimit(tFenlei, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tFenlei 实例对象
     * @return 实例对象
     */
    @Override
    public TFenlei insert(TFenlei tFenlei) {
        this.tFenleiDao.insert(tFenlei);
        return tFenlei;
    }

    /**
     * 修改数据
     *
     * @param tFenlei 实例对象
     * @return 实例对象
     */
    @Override
    public TFenlei update(TFenlei tFenlei) {
        this.tFenleiDao.update(tFenlei);
        return this.queryById(tFenlei.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tFenleiDao.deleteById(id) > 0;
    }
}
