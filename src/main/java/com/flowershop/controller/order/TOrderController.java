package com.flowershop.controller.order;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowershop.entity.order.TOrder;
import com.flowershop.service.order.TOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 订单表;(TOrder)表控制层
 *
 * @author makejava
 * @since 2024-05-20 19:31:44
 */
@RestController
@RequestMapping("tOrder")
public class TOrderController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TOrderService tOrderService;

    /**
     * 分页查询所有数据
     *
     * @param page   分页对象
     * @return 所有数据
     */
    @GetMapping("/getAll")
    public R getAll(Page<TOrder> page) {
        return success(this.tOrderService.page(page, Wrappers.emptyWrapper()));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tOrderService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tOrder 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TOrder tOrder) {
        return success(this.tOrderService.save(tOrder));
    }

    /**
     * 修改数据
     *
     * @param tOrder 实体对象
     * @return 修改结果
     */
    @PutMapping("/update/{id}")
    public R update(@PathVariable Integer id, TOrder tOrder) {
        //获取原始数据
        TOrder oldOrder = this.tOrderService.getById(id);
        //更新数据
        oldOrder.setOStatus(tOrder.getOStatus());
        oldOrder.setOAddress(tOrder.getOAddress());
        return success(this.tOrderService.updateById(oldOrder));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tOrderService.removeByIds(idList));
    }
}

