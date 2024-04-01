package com.flowershop.dao;

import com.flowershop.entity.TFenlei;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (TFenlei)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-01 23:48:21
 */
@Mapper
public interface TFenleiDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TFenlei queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tFenlei  查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<TFenlei> queryAllByLimit(TFenlei tFenlei, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tFenlei 查询条件
     * @return 总行数
     */
    long count(TFenlei tFenlei);

    /**
     * 新增数据
     *
     * @param tFenlei 实例对象
     * @return 影响行数
     */
    int insert(TFenlei tFenlei);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TFenlei> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TFenlei> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TFenlei> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TFenlei> entities);

    /**
     * 修改数据
     *
     * @param tFenlei 实例对象
     * @return 影响行数
     */
    int update(TFenlei tFenlei);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

