package com.flowershop.dao.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flowershop.entity.order.TCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购物车;(TCart)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-20 19:31:41
 */
@Mapper
public interface TCartDao extends BaseMapper<TCart> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TCart> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TCart> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TCart> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TCart> entities);

}

