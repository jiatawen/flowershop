package com.flowershop.service.impl;

import com.flowershop.entity.TGouwuche;
import com.flowershop.dao.TGouwucheDao;
import com.flowershop.service.TGouwucheService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * (TGouwuche)表服务实现类
 *
 * @author makejava
 * @since 2024-04-01 23:48:24
 */
@Service("tGouwucheService")
public class TGouwucheServiceImpl implements TGouwucheService {
    @Autowired
    private TGouwucheDao tGouwucheDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TGouwuche queryById(Integer id) {
        return this.tGouwucheDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tGouwuche   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<TGouwuche> queryByPage(TGouwuche tGouwuche, PageRequest pageRequest) {
        long total = this.tGouwucheDao.count(tGouwuche);
        return new PageImpl<>(this.tGouwucheDao.queryAllByLimit(tGouwuche, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tGouwuche 实例对象
     * @return 实例对象
     */
    @Override
    public TGouwuche insert(TGouwuche tGouwuche) {
        this.tGouwucheDao.insert(tGouwuche);
        return tGouwuche;
    }

    /**
     * 修改数据
     *
     * @param tGouwuche 实例对象
     * @return 实例对象
     */
    @Override
    public TGouwuche update(TGouwuche tGouwuche) {
        this.tGouwucheDao.update(tGouwuche);
        return this.queryById(tGouwuche.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tGouwucheDao.deleteById(id) > 0;
    }
}
