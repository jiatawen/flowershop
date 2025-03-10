package com.flowershop.controller.flower;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowershop.entity.flower.TClassify;
import com.flowershop.service.flower.TClassifyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 鲜花分类(TClassify)表控制层
 *
 * @author makejava
 * @since 2024-05-20 19:31:42
 */
@RestController
@RequestMapping("tClassify")
public class TClassifyController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TClassifyService tClassifyService;

    /**
     * 分页查询所有数据
     *
     * @param page      分页对象
     * @param tClassify 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TClassify> page, TClassify tClassify) {
        return success(this.tClassifyService.page(page, new QueryWrapper<>(tClassify)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tClassifyService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tClassify 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TClassify tClassify) {
        return success(this.tClassifyService.save(tClassify));
    }

    /**
     * 修改数据
     *
     * @param tClassify 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TClassify tClassify) {
        return success(this.tClassifyService.updateById(tClassify));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tClassifyService.removeByIds(idList));
    }
}

