package com.flowershop.controller.order;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowershop.entity.order.TCart;
import com.flowershop.service.order.TCartService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 购物车;(TCart)表控制层
 *
 * @author makejava
 * @since 2024-04-20 01:43:35
 */
@RestController
@RequestMapping("tCart")
public class TCartController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TCartService tCartService;

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param tCart 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TCart> page, TCart tCart) {
        return success(this.tCartService.page(page, new QueryWrapper<>(tCart)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tCartService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tCart 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TCart tCart) {
        return success(this.tCartService.save(tCart));
    }

    /**
     * 修改数据
     *
     * @param tCart 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TCart tCart) {
        return success(this.tCartService.updateById(tCart));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tCartService.removeByIds(idList));
    }
}

