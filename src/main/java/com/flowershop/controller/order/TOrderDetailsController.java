package com.flowershop.controller.order;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowershop.entity.order.TOrderDetails;
import com.flowershop.service.order.TOrderDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 订单详情表;(TOrderDetails)表控制层
 *
 * @author makejava
 * @since 2024-05-20 19:31:45
 */
@RestController
@RequestMapping("tOrderDetails")
public class TOrderDetailsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TOrderDetailsService tOrderDetailsService;

    @GetMapping("/getAll/{orderId}")
    public R getAll(@PathVariable Integer orderId) {
        //构造查询条件
        QueryWrapper<TOrderDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("o_id", orderId);
        return success(this.tOrderDetailsService.list(queryWrapper));
    }

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param tOrderDetails 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TOrderDetails> page, TOrderDetails tOrderDetails) {
        return success(this.tOrderDetailsService.page(page, new QueryWrapper<>(tOrderDetails)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tOrderDetailsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tOrderDetails 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TOrderDetails tOrderDetails) {
        return success(this.tOrderDetailsService.save(tOrderDetails));
    }

    /**
     * 修改数据
     *
     * @param tOrderDetails 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TOrderDetails tOrderDetails) {
        return success(this.tOrderDetailsService.updateById(tOrderDetails));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tOrderDetailsService.removeByIds(idList));
    }
}

