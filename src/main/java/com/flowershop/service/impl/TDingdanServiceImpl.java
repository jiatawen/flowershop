package com.flowershop.service.impl;

import com.flowershop.entity.TDingdan;
import com.flowershop.dao.TDingdanDao;
import com.flowershop.service.TDingdanService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * (TDingdan)表服务实现类
 *
 * @author makejava
 * @since 2024-04-01 23:48:21
 */
@Service("tDingdanService")
public class TDingdanServiceImpl implements TDingdanService {
    @Autowired
    private TDingdanDao tDingdanDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TDingdan queryById(Integer id) {
        return this.tDingdanDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tDingdan    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<TDingdan> queryByPage(TDingdan tDingdan, PageRequest pageRequest) {
        long total = this.tDingdanDao.count(tDingdan);
        return new PageImpl<>(this.tDingdanDao.queryAllByLimit(tDingdan, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tDingdan 实例对象
     * @return 实例对象
     */
    @Override
    public TDingdan insert(TDingdan tDingdan) {
        this.tDingdanDao.insert(tDingdan);
        return tDingdan;
    }

    /**
     * 修改数据
     *
     * @param tDingdan 实例对象
     * @return 实例对象
     */
    @Override
    public TDingdan update(TDingdan tDingdan) {
        this.tDingdanDao.update(tDingdan);
        return this.queryById(tDingdan.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tDingdanDao.deleteById(id) > 0;
    }
}
