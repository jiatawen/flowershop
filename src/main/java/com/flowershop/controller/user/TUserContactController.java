package com.flowershop.controller.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowershop.entity.user.TUserContact;
import com.flowershop.service.user.TUserContactService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 收货联系方式表;(TUserContact)表控制层
 *
 * @author makejava
 * @since 2024-04-20 01:43:39
 */
@RestController
@RequestMapping("tUserContact")
public class TUserContactController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TUserContactService tUserContactService;

    /**
     * 分页查询所有数据
     *
     * @param page         分页对象
     * @param tUserContact 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TUserContact> page, TUserContact tUserContact) {
        return success(this.tUserContactService.page(page, new QueryWrapper<>(tUserContact)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tUserContactService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tUserContact 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TUserContact tUserContact) {
        return success(this.tUserContactService.save(tUserContact));
    }

    /**
     * 修改数据
     *
     * @param tUserContact 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TUserContact tUserContact) {
        return success(this.tUserContactService.updateById(tUserContact));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tUserContactService.removeByIds(idList));
    }
}

