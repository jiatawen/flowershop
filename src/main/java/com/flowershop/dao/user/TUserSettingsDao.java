package com.flowershop.dao.user;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.flowershop.entity.user.TUserSettings;

/**
 * 用户鲜花期望表;(TUserSettings)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-20 01:43:40
 */
@Mapper
public interface TUserSettingsDao extends BaseMapper<TUserSettings> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUserSettings> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TUserSettings> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUserSettings> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TUserSettings> entities);

}

