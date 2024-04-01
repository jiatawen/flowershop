package com.flowershop.service;

import com.flowershop.entity.TGouwuche;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TGouwuche)表服务接口
 *
 * @author makejava
 * @since 2024-04-01 23:48:24
 */
public interface TGouwucheService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TGouwuche queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tGouwuche   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<TGouwuche> queryByPage(TGouwuche tGouwuche, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tGouwuche 实例对象
     * @return 实例对象
     */
    TGouwuche insert(TGouwuche tGouwuche);

    /**
     * 修改数据
     *
     * @param tGouwuche 实例对象
     * @return 实例对象
     */
    TGouwuche update(TGouwuche tGouwuche);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
