package com.flowershop.dao.flower;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flowershop.entity.flower.TFlowerClassify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 鲜花分类，鲜花连理表(TFlowerClassify)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-20 19:31:44
 */
@Mapper
public interface TFlowerClassifyDao extends BaseMapper<TFlowerClassify> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TFlowerClassify> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TFlowerClassify> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TFlowerClassify> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TFlowerClassify> entities);

}

