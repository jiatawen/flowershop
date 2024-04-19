package com.flowershop.controller.flower;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowershop.entity.flower.TFlowerClassify;
import com.flowershop.service.flower.TFlowerClassifyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 鲜花分类(TFlowerClassify)表控制层
 *
 * @author makejava
 * @since 2024-04-20 01:43:36
 */
@RestController
@RequestMapping("tFlowerClassify")
public class TFlowerClassifyController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TFlowerClassifyService tFlowerClassifyService;

    /**
     * 分页查询所有数据
     *
     * @param page            分页对象
     * @param tFlowerClassify 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TFlowerClassify> page, TFlowerClassify tFlowerClassify) {
        return success(this.tFlowerClassifyService.page(page, new QueryWrapper<>(tFlowerClassify)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tFlowerClassifyService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tFlowerClassify 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TFlowerClassify tFlowerClassify) {
        return success(this.tFlowerClassifyService.save(tFlowerClassify));
    }

    /**
     * 修改数据
     *
     * @param tFlowerClassify 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TFlowerClassify tFlowerClassify) {
        return success(this.tFlowerClassifyService.updateById(tFlowerClassify));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tFlowerClassifyService.removeByIds(idList));
    }
}

