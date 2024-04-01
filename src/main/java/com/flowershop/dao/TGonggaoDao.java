package com.flowershop.dao;

import com.flowershop.entity.TGonggao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (TGonggao)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-01 23:48:22
 */
@Mapper
public interface TGonggaoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TGonggao queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tGonggao 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<TGonggao> queryAllByLimit(TGonggao tGonggao, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tGonggao 查询条件
     * @return 总行数
     */
    long count(TGonggao tGonggao);

    /**
     * 新增数据
     *
     * @param tGonggao 实例对象
     * @return 影响行数
     */
    int insert(TGonggao tGonggao);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TGonggao> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TGonggao> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TGonggao> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TGonggao> entities);

    /**
     * 修改数据
     *
     * @param tGonggao 实例对象
     * @return 影响行数
     */
    int update(TGonggao tGonggao);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

