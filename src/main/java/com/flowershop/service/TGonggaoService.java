package com.flowershop.service;

import com.flowershop.entity.TGonggao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TGonggao)表服务接口
 *
 * @author makejava
 * @since 2024-04-01 23:48:23
 */
public interface TGonggaoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TGonggao queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tGonggao    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<TGonggao> queryByPage(TGonggao tGonggao, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tGonggao 实例对象
     * @return 实例对象
     */
    TGonggao insert(TGonggao tGonggao);

    /**
     * 修改数据
     *
     * @param tGonggao 实例对象
     * @return 实例对象
     */
    TGonggao update(TGonggao tGonggao);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
