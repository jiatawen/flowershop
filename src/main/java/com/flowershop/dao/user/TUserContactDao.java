package com.flowershop.dao.user;

import com.flowershop.entity.user.TUserContact;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 收货联系方式表;(TUserContact)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-26 13:01:52
 */
@Mapper
public interface TUserContactDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUserContact queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tUserContact 查询条件
     * @param pageable     分页对象
     * @return 对象列表
     */
    List<TUserContact> queryAllByLimit(TUserContact tUserContact, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tUserContact 查询条件
     * @return 总行数
     */
    long count(TUserContact tUserContact);

    /**
     * 新增数据
     *
     * @param tUserContact 实例对象
     * @return 影响行数
     */
    int insert(TUserContact tUserContact);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUserContact> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TUserContact> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUserContact> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TUserContact> entities);

    /**
     * 修改数据
     *
     * @param tUserContact 实例对象
     * @return 影响行数
     */
    int update(TUserContact tUserContact);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

