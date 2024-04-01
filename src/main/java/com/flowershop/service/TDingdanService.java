package com.flowershop.service;

import com.flowershop.entity.TDingdan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TDingdan)表服务接口
 *
 * @author makejava
 * @since 2024-04-01 23:48:21
 */
public interface TDingdanService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TDingdan queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tDingdan    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<TDingdan> queryByPage(TDingdan tDingdan, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tDingdan 实例对象
     * @return 实例对象
     */
    TDingdan insert(TDingdan tDingdan);

    /**
     * 修改数据
     *
     * @param tDingdan 实例对象
     * @return 实例对象
     */
    TDingdan update(TDingdan tDingdan);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
