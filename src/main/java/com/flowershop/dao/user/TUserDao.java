package com.flowershop.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flowershop.entity.user.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表;(TUser)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-20 19:54:58
 */
@Mapper
public interface TUserDao extends BaseMapper<TUser> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TUser> entities);

    TUser findByEmail(String email);
}

