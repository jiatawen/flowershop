package com.flowershop.service.user;

import com.flowershop.entity.user.TUserContact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 收货联系方式表;(TUserContact)表服务接口
 *
 * @author makejava
 * @since 2024-04-26 13:01:53
 */
public interface TUserContactService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUserContact queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tUserContact 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    Page<TUserContact> queryByPage(TUserContact tUserContact, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tUserContact 实例对象
     * @return 实例对象
     */
    TUserContact insert(TUserContact tUserContact);

    /**
     * 修改数据
     *
     * @param tUserContact 实例对象
     * @return 实例对象
     */
    TUserContact update(TUserContact tUserContact);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
