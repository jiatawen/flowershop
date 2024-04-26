package com.flowershop.service.impl.user;

import com.flowershop.entity.user.TUserContact;
import com.flowershop.dao.user.TUserContactDao;
import com.flowershop.service.user.TUserContactService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 收货联系方式表;(TUserContact)表服务实现类
 *
 * @author makejava
 * @since 2024-04-26 13:01:53
 */
@Service("tUserContactService")
public class TUserContactServiceImpl implements TUserContactService {
    @Autowired
    private TUserContactDao tUserContactDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TUserContact queryById(Integer id) {
        return this.tUserContactDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tUserContact 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @Override
    public Page<TUserContact> queryByPage(TUserContact tUserContact, PageRequest pageRequest) {
        long total = this.tUserContactDao.count(tUserContact);
        return new PageImpl<>(this.tUserContactDao.queryAllByLimit(tUserContact, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tUserContact 实例对象
     * @return 实例对象
     */
    @Override
    public TUserContact insert(TUserContact tUserContact) {
        this.tUserContactDao.insert(tUserContact);
        return tUserContact;
    }

    /**
     * 修改数据
     *
     * @param tUserContact 实例对象
     * @return 实例对象
     */
    @Override
    public TUserContact update(TUserContact tUserContact) {
        this.tUserContactDao.update(tUserContact);
        return this.queryById(tUserContact.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tUserContactDao.deleteById(id) > 0;
    }
}
