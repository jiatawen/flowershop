package com.flowershop.service;

import com.flowershop.entity.TFenlei;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TFenlei)表服务接口
 *
 * @author makejava
 * @since 2024-04-01 23:48:22
 */
public interface TFenleiService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TFenlei queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tFenlei     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<TFenlei> queryByPage(TFenlei tFenlei, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tFenlei 实例对象
     * @return 实例对象
     */
    TFenlei insert(TFenlei tFenlei);

    /**
     * 修改数据
     *
     * @param tFenlei 实例对象
     * @return 实例对象
     */
    TFenlei update(TFenlei tFenlei);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
