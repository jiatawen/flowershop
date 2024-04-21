package com.flowershop.dao.user;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flowershop.entity.user.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.flowershop.entity.user.TUserLoginBehavior;

/**
 * 用户登录行为记录表;(TUserLoginBehavior)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-20 01:43:39
 */
@Mapper
public interface TUserLoginBehaviorDao extends BaseMapper<TUserLoginBehavior> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUserLoginBehavior> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TUserLoginBehavior> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUserLoginBehavior> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TUserLoginBehavior> entities);

    /**
     * 通过邮箱查找数据
     *
     * @param email 实例对象列表
     * @return TUser 实例对象
     */
    TUser findByEmail(@Param("email") String email);
}

