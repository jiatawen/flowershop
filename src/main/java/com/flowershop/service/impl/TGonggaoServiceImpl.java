package com.flowershop.service.impl;

import com.flowershop.entity.TGonggao;
import com.flowershop.dao.TGonggaoDao;
import com.flowershop.service.TGonggaoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * (TGonggao)表服务实现类
 *
 * @author makejava
 * @since 2024-04-01 23:48:23
 */
@Service("tGonggaoService")
public class TGonggaoServiceImpl implements TGonggaoService {
    @Autowired
    private TGonggaoDao tGonggaoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TGonggao queryById(Integer id) {
        return this.tGonggaoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tGonggao    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<TGonggao> queryByPage(TGonggao tGonggao, PageRequest pageRequest) {
        long total = this.tGonggaoDao.count(tGonggao);
        return new PageImpl<>(this.tGonggaoDao.queryAllByLimit(tGonggao, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tGonggao 实例对象
     * @return 实例对象
     */
    @Override
    public TGonggao insert(TGonggao tGonggao) {
        this.tGonggaoDao.insert(tGonggao);
        return tGonggao;
    }

    /**
     * 修改数据
     *
     * @param tGonggao 实例对象
     * @return 实例对象
     */
    @Override
    public TGonggao update(TGonggao tGonggao) {
        this.tGonggaoDao.update(tGonggao);
        return this.queryById(tGonggao.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tGonggaoDao.deleteById(id) > 0;
    }
}
